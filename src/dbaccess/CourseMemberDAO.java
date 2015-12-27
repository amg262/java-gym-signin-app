
package dbaccess;

import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Andrew Gunn | amgunn1@hotmail.com
 */
public class CourseMemberDAO implements I_CourseMemberDAO {

    private I_DBAccessor db;
    private static final String MySQL_DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL_PATH = "jdbc:mysql://localhost:3306/core_health1";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "admin";

    private static final String RETRIEVE_ALL_COURSE_MEMBERS =
            "SELECT * " +
            "FROM course_member ;";

    /**
     *
     */
    public CourseMemberDAO() {
    }

    
    
    /**
     *
     * @param db
     */
    public CourseMemberDAO(I_DBAccessor db) {
        this.db = db;
    }
    
    
    @Override
    public void openLocalDBConnection() throws DataAccessException {
        try {
            db.openConnection(MySQL_DRIVER, URL_PATH, USERNAME, PASSWORD);
            
        } catch (IllegalArgumentException iae){
            throw new DataAccessException (iae.getMessage(), iae);
        } catch (ClassNotFoundException cnfe){
            throw new DataAccessException (cnfe.getMessage(), cnfe);
        } catch (SQLException sqle){
            throw new DataAccessException (sqle.getMessage(), sqle);
        }
    }
    
    

    @Override
    public List<CourseMember> retrieveAllCourseMembers() throws DataAccessException {
        this.openLocalDBConnection();
        
        List<Map> rawData = new ArrayList<>();
        List<CourseMember> records = new ArrayList<>();
        
        try {
            rawData = db.retrieveRecords(RETRIEVE_ALL_COURSE_MEMBERS, true);
        } catch (SQLException sqle){
            throw new DataAccessException (sqle.getMessage(), sqle);
        } catch (Exception e){
            throw new DataAccessException (e.getMessage(), e);
        }
        
        CourseMember courseMember = null;
        
        for (Map map : rawData){
            courseMember = new CourseMember();
            
            String memberId = map.get("member_id").toString();
            courseMember.setMemberId(new Integer(memberId));
            
            String courseId = map.get("course_id").toString();
            courseMember.setCourseId(new Integer(courseId));
            
            
            records.add(courseMember);
                    
        }
        return records;
    }

    @Override
    public CourseMember retreiveCourseMemberByMemberId(String memberId) throws DataAccessException {
        this.openLocalDBConnection();
        
        Map record;
        
        try {
            record = db.retrieveRecordByID("course_member", "member_id",
                                            new Integer(memberId), true);  
        } catch (SQLException sqle){
            throw new DataAccessException(sqle.getMessage(), sqle);
        } catch (Exception e) {
            throw new DataAccessException(e.getMessage(), e);
        }
        
        
        CourseMember courseMember = null;
        
            courseMember = new CourseMember();
            
            String memId = record.get("member_id").toString();
            courseMember.setMemberId(new Integer(memId));
            
            String courseId = record.get("course_id").toString();
            courseMember.setCourseId(new Integer(courseId));
            

        return courseMember;
        
    }

    

    @Override
    public void saveCourseMember(CourseMember courseMember) throws DataAccessException {
        this.openLocalDBConnection();
        
        List<String> fields;
        List values;
        String tableName = "course_member";
        
        fields = new ArrayList();
        fields.add("member_id");
        fields.add("course_id");

        
        values = new ArrayList();
        values.add(courseMember.getMemberId());
        values.add(courseMember.getCourseId());

        
        try {
            
            db.insertRecord(tableName, fields, values, true);
            
        } catch (SQLException sqle){
            throw new DataAccessException(sqle.getMessage(), sqle);
        } catch (Exception e){
            throw new DataAccessException(e.getMessage(), e);
        }
    
    }

    @Override
    public void deleteCourseMember(CourseMember courseMember) throws DataAccessException {
        this.openLocalDBConnection();
        
        try {
            db.deleteRecords("course_member", "member_id", courseMember.getMemberId(), true);
        } catch (SQLException sqle){
            throw new DataAccessException(sqle.getMessage(), sqle);
        } catch (Exception e) {
            throw new DataAccessException(e.getMessage(), e);
        }
        
    }
    
    /**
     *
     * @param args
     * @throws DataAccessException
     */
    public static void main(String[] args) throws DataAccessException {
        
        CourseMemberDAO dao = new CourseMemberDAO(new DBAccessor());
        CourseMember cm = new CourseMember();
        
        dao.openLocalDBConnection();
        cm.setMemberId(2);
        cm.setCourseId(10);
        dao.deleteCourseMember(cm);
        
        System.out.println(cm.toString());
        //System.out.println(dao.retrieveAllCourseMembers());
        
    }
    
    
}
