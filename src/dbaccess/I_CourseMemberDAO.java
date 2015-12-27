
package dbaccess;

import java.util.List;

/**
 *
 * @author Andrew Gunn | amgunn1@hotmail.com
 */
public interface I_CourseMemberDAO {
    
   /**
     *
     * @throws DataAccessException
     */
    public abstract void openLocalDBConnection() throws DataAccessException;
    
    /**
     *
     * @return 
     * @returnp
     * @throws DataAccessException
     */
    public abstract List<CourseMember> retrieveAllCourseMembers() throws DataAccessException;
    
    /**
     *
     * @param memberId 
     * @return
     * @throws DataAccessException
     */
    public abstract CourseMember retreiveCourseMemberByMemberId(String memberId) throws DataAccessException;
    

    
    /**
     *
     * @param courseMember 
     * @throws DataAccessException
     */
    public abstract void saveCourseMember(CourseMember courseMember) throws DataAccessException;
    
    /**
     *
     * @param courseMember 
     * @throws DataAccessException
     */
    public abstract void deleteCourseMember(CourseMember courseMember) throws DataAccessException;

}
