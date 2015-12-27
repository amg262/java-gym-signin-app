
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
public class MemberDAO implements I_MemberDAO {
    
    
    private I_DBAccessor db;
    private static final String MySQL_DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL_PATH = "jdbc:mysql://localhost:3306/core_health1";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "admin";

    private static final String RETRIEVE_ALL_MEMBERS =
            "SELECT * " +
            "FROM member ;";
                
    /**
     *
     */
    public MemberDAO() {}
    
    
    /**
     *
     * @param db
     */
    public MemberDAO(I_DBAccessor db) {
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
    public List<Member> retrieveAllMemebers() throws DataAccessException {
        this.openLocalDBConnection();
        
        List<Map> rawData = new ArrayList<>();
        List<Member> records = new ArrayList<>();
        
        try {
            rawData = db.retrieveRecords(RETRIEVE_ALL_MEMBERS, true);
        } catch (SQLException sqle){
            throw new DataAccessException (sqle.getMessage(), sqle);
        } catch (Exception e){
            throw new DataAccessException (e.getMessage(), e);
        }
        
        Member member = null;
        
        for (Map map : rawData) {
            member = new Member();
            
            String id = map.get("id").toString();
            member.setId(new Integer(id));
            
            String memType = map.get("mem_type").toString();
            member.setMemType(new Integer(memType));

            String freeSession = map.get("free_session").toString();
            member.setFreeSession(new Integer(freeSession));
            
            String memPayment = map.get("mem_payment").toString();
            member.setMemPayment(new Integer(memPayment));
                        
            String memStatus = map.get("mem_status").toString();
            member.setMemStatus(new Integer(memStatus));
                      
            String lastName = map.get("last_name").toString();
            member.setLastName(lastName);
            
            String firstName = map.get("first_name").toString();
            member.setFirstName(firstName);
            
            String address = map.get("address").toString();
            member.setAddress(address);
            
            String city = map.get("city").toString();
            member.setCity(city);
            
            String state = map.get("state").toString();
            member.setState(state);
            
            String zip = map.get("zip").toString();
            member.setZip(zip);
            
            String phone = map.get("phone").toString();
            member.setPhone(phone);
            
            String email = map.get("email").toString();
            member.setEmail(email);
            
            Date joinDate = (Date)map.get("join_date");
            member.setJoinDate(joinDate);
            
            
            
            records.add(member);
        }
        
        return records;
    }

    @Override
    public Member retreiveMemberById(String id) throws DataAccessException {
        this.openLocalDBConnection();
        
        Map record;
        
        try {
            record = db.retrieveRecordByID("member", "id",
                                            new Integer(id), true);  
        } catch (SQLException sqle){
            throw new DataAccessException(sqle.getMessage(), sqle);
        } catch (Exception e) {
            throw new DataAccessException(e.getMessage(), e);
        }
        
        Member member = new Member();
        
        member.setId(new Integer(record.get("id").toString()));
        member.setMemType(new Integer(record.get("mem_type").toString()));
        member.setFreeSession(new Integer(record.get("free_session").toString()));
        member.setMemPayment(new Integer(record.get("mem_payment").toString()));
        member.setMemStatus(new Integer(record.get("mem_status").toString()));
        
        member.setLastName(record.get("last_name").toString());
        member.setFirstName(record.get("first_name").toString());
        member.setAddress(record.get("address").toString());
        member.setCity(record.get("city").toString());
        member.setState(record.get("state").toString());
        member.setZip(record.get("zip").toString());
        member.setPhone(record.get("phone").toString());
        member.setEmail(record.get("email").toString());
        
        Date joinDate = (Date)record.get("join_date");
        member.setJoinDate(joinDate);
        
        
        
        return member;
    }
    
    /**
     *
     * @param keyword
     * @return
     * @throws DataAccessException
     */
    @Override
    public List<MemberDTO> retreiveMemberInfo(String keyword) throws DataAccessException {
        final String GET_MEMBER_INFO = 
                "select member.id, member.last_name, member.first_name, " +
                " membership_type.type, membership_payment.frequency, " +
                " free_session.condition, membership_status.status " +
                " from member join membership_status on member.mem_status = membership_status.id " +
                " join membership_payment on member.mem_payment = membership_payment.id " +
                " join membership_type on member.mem_type = membership_type.id " +
                " join free_session on member.free_session = free_session.id " +
                " WHERE member.last_name like '%" + keyword + "%' " +
                " or member.first_name like '%" + keyword + "%' " +
                " order by member.id ";
         
        List<Map> rawData = new ArrayList<>();
        List<MemberDTO> records = new ArrayList<>();
        
        
        try {
            rawData = db.retrieveRecords(GET_MEMBER_INFO, true);
        } catch (SQLException sqle){
            throw new DataAccessException (sqle.getMessage(), sqle);
        } catch (Exception e){
            throw new DataAccessException (e.getMessage(), e);
        }
        MemberDTO member = null;
        
        for (Map map : rawData){
            member = new MemberDTO();
            
            String id = map.get("id").toString();
            member.setMemberId(new Integer(id));
            
            String lastName = map.get("last_name").toString();
            member.setLastName(lastName);
            
            String firstName = map.get("first_name").toString();
            member.setFirstName(firstName);
            
            String memType = map.get("type").toString();
            member.setMemType(memType);
            
            String memPayment = map.get("frequency").toString();
            member.setMemPayment(memPayment);
            
            String freeSession = map.get("condition").toString();
            member.setFreeSession(freeSession);
            
            String memStatus = map.get("status").toString();
            member.setMemStatus(memStatus);

            
            records.add(member);
                    
        }
        return records;
    }
    
    /**
     *
     * @param keyword
     * @return
     * @throws DataAccessException
     */
    @Override
    public List<Member> retrieveMemberByKeyword(String keyword) throws DataAccessException {
        
        final String GET_MEMBER_BY_KEYWORD = 
            "SELECT * " +
            "FROM member " +
            "WHERE member.last_name like '%" + keyword + "%' " + 
                " or member.first_name like '%" + keyword + "%' ; ";
        
        List<Map> rawData = new ArrayList<>();
        List<Member> records = new ArrayList<>();
        
        try {
            rawData = db.retrieveRecords(GET_MEMBER_BY_KEYWORD, true);
        } catch (SQLException sqle){
            throw new DataAccessException (sqle.getMessage(), sqle);
        } catch (Exception e){
            throw new DataAccessException (e.getMessage(), e);
        }
        
        Member member = null;
        
        for (Map map : rawData) {
            member = new Member();
            
            String id = map.get("id").toString();
            member.setId(new Integer(id));
            
            String memType = map.get("mem_type").toString();
            member.setMemType(new Integer(memType));

            String freeSession = map.get("free_session").toString();
            member.setFreeSession(new Integer(freeSession));
            
            String memPayment = map.get("mem_payment").toString();
            member.setMemPayment(new Integer(memPayment));
                        
            String memStatus = map.get("mem_status").toString();
            member.setMemStatus(new Integer(memStatus));
                      
            String lastName = map.get("last_name").toString();
            member.setLastName(lastName);
            
            String firstName = map.get("first_name").toString();
            member.setFirstName(firstName);
            
            String address = map.get("address").toString();
            member.setAddress(address);
            
            String city = map.get("city").toString();
            member.setCity(city);
            
            String state = map.get("state").toString();
            member.setState(state);
            
            String zip = map.get("zip").toString();
            member.setZip(zip);
            
            String phone = map.get("phone").toString();
            member.setPhone(phone);
            
            String email = map.get("email").toString();
            member.setEmail(email);
            
            Date joinDate = (Date)map.get("join_date");
            member.setJoinDate(joinDate);
            
            
            
            records.add(member);
            
        }
        return records;
    }
    
    

    @Override
    public void saveMember(Member member) throws DataAccessException {
        this.openLocalDBConnection();
        
        List<String> fields;
        List values;
        String tableName = "member";
        
        fields = new ArrayList<>();
        fields.add("mem_type");
        fields.add("free_session");
        fields.add("mem_payment");
        fields.add("mem_status");
        fields.add("last_name");
        fields.add("first_name");
        fields.add("address");
        fields.add("city");
        fields.add("state");
        fields.add("zip");
        fields.add("phone");
        fields.add("email");
        fields.add("join_date");
        
        
        
        
        values = new ArrayList();
        values.add(member.getMemType());
        values.add(member.getFreeSession());
        values.add(member.getMemPayment());
        values.add(member.getMemStatus());
        values.add(member.getFirstName());
        values.add(member.getLastName());
        values.add(member.getAddress());
        values.add(member.getCity());
        values.add(member.getState());
        values.add(member.getZip());
        values.add(member.getPhone());
        values.add(member.getEmail());
        values.add(member.getJoinDate());
        
        
        
        try {
            if (member.getId() == 0){
                db.insertRecord(tableName, fields, values, true);
                
            } else {
                db.updateRecords(tableName, fields, values, "id", member.getId(), true);
            }
            
        } catch (SQLException sqle){
            throw new DataAccessException(sqle.getMessage(), sqle);
        } catch (Exception e){
            throw new DataAccessException(e.getMessage(), e);
        }
    }

    @Override
    public void deleteMember(Member member) throws DataAccessException {
        this.openLocalDBConnection();
        
        try {
            db.deleteRecords("member", "id", member.getId(), true);
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
        
        MemberDAO dao = new MemberDAO(new DBAccessor());
        List<Member> members = new ArrayList();
        dao.openLocalDBConnection();
        //System.out.println(dao.retrieveAllMemebers());
//        members = dao.retrieveMemberByKeyword("white");
//        System.out.println(members.toString());
        System.out.println(dao.retreiveMemberInfo("a"));
        
        
    }
}
