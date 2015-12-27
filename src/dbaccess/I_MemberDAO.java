
package dbaccess;

import java.util.List;

/**
 *
 * Interface that states methods the MenuDAO will have to implement
 * 
 * @author Andrew Gunn | amgunn1@hotmail.com
 */
public interface I_MemberDAO {
    
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
    public abstract List<Member> retrieveAllMemebers() throws DataAccessException;
    
    /**
     *
     * @param id 
     * @return
     * @throws DataAccessException
     */
    public abstract Member retreiveMemberById(String id) throws DataAccessException;
    
    
    /**
     *
     * @param keyword
     * @return
     * @throws DataAccessException
     */
    public abstract List<Member> retrieveMemberByKeyword(String keyword) throws DataAccessException;
    
    
    /**
     *
     * @param keyword
     * @return
     * @throws DataAccessException
     */
    public abstract List<MemberDTO> retreiveMemberInfo(String keyword) throws DataAccessException;
    /**
     *
     * @param member
     * @throws DataAccessException
     */
    public abstract void saveMember(Member member) throws DataAccessException;
    
    /**
     *
     * @param member
     * @throws DataAccessException
     */
    public abstract void deleteMember(Member member) throws DataAccessException;
    
}
