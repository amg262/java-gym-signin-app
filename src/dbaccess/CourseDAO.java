
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
public class CourseDAO implements I_CourseDAO {
    
    
    private I_DBAccessor db;
    private static final String MySQL_DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL_PATH = "jdbc:mysql://localhost:3306/core_health1";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "admin";

    private static final String RETRIEVE_ALL_COURSES =
            "SELECT * " +
            "FROM course ;";

    
    
    /**
     *
     */
    public CourseDAO() {
    }

    
    /**
     *
     * @param db
     */
    public CourseDAO(I_DBAccessor db) {
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
    public List<Course> retrieveAllCourses() throws DataAccessException {
        this.openLocalDBConnection();
        
        List<Map> rawData = new ArrayList<>();
        List<Course> records = new ArrayList<>();
        
        try {
            rawData = db.retrieveRecords(RETRIEVE_ALL_COURSES, true);
        } catch (SQLException sqle){
            throw new DataAccessException (sqle.getMessage(), sqle);
        } catch (Exception e){
            throw new DataAccessException (e.getMessage(), e);
        }
        
        Course course = null;
        
        for (Map map : rawData){
            course = new Course();
            
            String id = map.get("id").toString();
            course.setId(new Integer(id));
            
            String instructorId = map.get("instructor_id").toString();
            course.setInstructorId(new Integer(instructorId));
            
            String typeId = map.get("type_id").toString();
            course.setTypeId(new Integer(typeId));
            
            String title = map.get("title").toString();
            course.setTitle(title);
            
            Date startDate = (Date)map.get("start_date");
            course.setStartDate(startDate);
            
            Time startTime = (Time)map.get("start_time");
            course.setStartTime(startTime);
            
            Date endDate = (Date)map.get("end_date");
            course.setEndDate(endDate);
            
            Time endTime = (Time)map.get("end_time");
            course.setEndTime(endTime);
            
            records.add(course);
                    
        }
        return records;
    }
    

    
    @Override
    public Course retreiveCourseById(String id) throws DataAccessException {
        this.openLocalDBConnection();
        
        Map record;
        
        try {
            record = db.retrieveRecordByID("course", "id",
                                            new Integer(id), true);  
        } catch (SQLException sqle){
            throw new DataAccessException(sqle.getMessage(), sqle);
        } catch (Exception e) {
            throw new DataAccessException(e.getMessage(), e);
        }
        
        
        Course course = new Course();
        
            String memberId = record.get("id").toString();
            course.setId(new Integer(memberId));
            
            String instructorId = record.get("instructor_id").toString();
            course.setInstructorId(new Integer(instructorId));
            
            String typeId = record.get("type_id").toString();
            course.setTypeId(new Integer(typeId));
            
            String title = record.get("title").toString();
            course.setTitle(title);
            
            Date startDate = (Date)record.get("start_date");
            course.setStartDate(startDate);
            
            Time startTime = (Time)record.get("start_time");
            course.setStartTime(startTime);
            
            Date endDate = (Date)record.get("end_date");
            course.setEndDate(endDate);
            
            Time endTime = (Time)record.get("end_time");
            course.setEndTime(endTime);
        
        
        return course;
    }
    
    

    @Override
    public List<Course> retrieveCourseByKeyword(String keyword) throws DataAccessException {
        
        final String GET_COURSE_BY_KEYWORD = 
            "SELECT * " +
            "FROM course JOIN course_type ON course.type_id = course_type.id " +
            "WHERE course.title like '%" + keyword + "%'" +
            " or course_type.type like '%" + keyword + "%'";
        
        List<Map> rawData = new ArrayList<>();
        List<Course> records = new ArrayList<>();
        
        
        try {
            rawData = db.retrieveRecords(GET_COURSE_BY_KEYWORD, true);
        } catch (SQLException sqle){
            throw new DataAccessException (sqle.getMessage(), sqle);
        } catch (Exception e){
            throw new DataAccessException (e.getMessage(), e);
        }
        Course course = null;
        
        for (Map map : rawData){
            course = new Course();
            
            String id = map.get("id").toString();
            course.setId(new Integer(id));
            
            String instructorId = map.get("instructor_id").toString();
            course.setInstructorId(new Integer(instructorId));
            
            String typeId = map.get("type_id").toString();
            course.setTypeId(new Integer(typeId));
            
            String title = map.get("title").toString();
            course.setTitle(title);
            
            Date startDate = (Date)map.get("start_date");
            course.setStartDate(startDate);
            
            Time startTime = (Time)map.get("start_time");
            course.setStartTime(startTime);
            
            Date endDate = (Date)map.get("end_date");
            course.setEndDate(endDate);
            
            Time endTime = (Time)map.get("end_time");
            course.setEndTime(endTime);
            
            records.add(course);
                    
        }
        return records;
    }

    @Override
    public void saveCourse(Course course) throws DataAccessException {
        this.openLocalDBConnection();
        
        List<String> fields;
        List values;
        String tableName = "course";
        
        fields = new ArrayList();
        fields.add("instructor_id");
        fields.add("type_id");
        fields.add("title");
        fields.add("capacity");
        fields.add("start_date");
        fields.add("start_time");
        fields.add("end_date");
        fields.add("end_time");
        
        values = new ArrayList();
        values.add(course.getInstructorId());
        values.add(course.getTypeId());
        values.add(course.getTitle());
        values.add(course.getStartDate());
        values.add(course.getStartTime());
        values.add(course.getEndDate());
        values.add(course.getEndTime());
        
        try {
            if (course.getId() == 0){
                db.insertRecord(tableName, fields, values, true);
                
            } else {
                db.updateRecords(tableName, fields, values, "id", course.getId(), true);
            }
            
        } catch (SQLException sqle){
            throw new DataAccessException(sqle.getMessage(), sqle);
        } catch (Exception e){
            throw new DataAccessException(e.getMessage(), e);
        }
        
    }

    @Override
    public void deleteCourse(Course course) throws DataAccessException {
        this.openLocalDBConnection();
        
        try {
            db.deleteRecords("course", "id", course.getId(), true);
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
        
        CourseDAO dao = new CourseDAO(new DBAccessor());
        List<Course> courses = new ArrayList();
        
        dao.openLocalDBConnection();
        //System.out.println(dao.retrieveAllCourses());
        //courses = dao.retrieveCourseByKeyword("defense");
        courses = dao.retrieveAllCourses();
        System.out.println(courses.toString());
    }

}
