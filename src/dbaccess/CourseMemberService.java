
package dbaccess;

import java.util.List;

/**
 *
 * @author Andrew Gunn | amgunn1@hotmail.com
 */
public class CourseMemberService {
    
    private I_CourseMemberDAO courseMemberDAO;
    
    /**
     *
     */
    public CourseMemberService(){
        I_DBAccessor db = new DBAccessor();
        courseMemberDAO = new CourseMemberDAO(db);
        
    }
    
    /**
     *
     * @return
     * @throws DataAccessException
     */
    public List<CourseMember> getAllCourseMembers() throws DataAccessException{
        return courseMemberDAO.retrieveAllCourseMembers();
    }
    
    /**
     *
     * @param memberId
     * @return
     * @throws DataAccessException
     */
    public CourseMember getCourseMemberByMemberId(String memberId) throws DataAccessException{
        return courseMemberDAO.retreiveCourseMemberByMemberId(memberId);
    }
    
    /**
     *
     * @param courseMember
     * @throws DataAccessException
     */
    public void saveCourseMember(CourseMember courseMember) throws DataAccessException{
        courseMemberDAO.saveCourseMember(courseMember);
    }
    
    /**
     *
     * @param courseMember
     * @throws DataAccessException
     */
    public void deleteCourseMember(CourseMember courseMember) throws DataAccessException{
        courseMemberDAO.saveCourseMember(courseMember);
    }

}
