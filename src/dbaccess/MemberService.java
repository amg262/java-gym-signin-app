
package dbaccess;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Andrew Gunn | amgunn1@hotmail.com
 */
public class MemberService {
    
    private I_MemberDAO memberDAO;
    
    
    /**
     *
     */
    public MemberService() {
        I_DBAccessor db = new DBAccessor();
        memberDAO = new MemberDAO(db);
    }
    
    /**
     *
     * @return
     * @throws DataAccessException
     */
    public List<Member> getAllMembers() throws DataAccessException {
        return memberDAO.retrieveAllMemebers();
    }
    
    /**
     *
     * @param memberId
     * @return
     * @throws DataAccessException
     */
    public Member getMemberById(String memberId) throws DataAccessException {
        return memberDAO.retreiveMemberById(memberId);
    }
    
    /**
     *
     * @param keyword
     * @return
     * @throws DataAccessException
     */
    public List<MemberDTO> getMemberInfo(String keyword) throws DataAccessException {
        return memberDAO.retreiveMemberInfo(keyword);
    }
    
    /**
     *
     * @param member
     * @throws DataAccessException
     */
    public void saveMember(Member member) throws DataAccessException {
        memberDAO.saveMember(member);
    }
    
    /**
     *
     * @param member
     * @throws DataAccessException
     */
    public void deleteMember(Member member) throws DataAccessException {
        memberDAO.deleteMember(member);
    }
    
    
    public static void main(String[] args) throws DataAccessException {
        MemberService ms = new MemberService();
        
        System.out.println(ms.getMemberInfo("a").toString());
    }
}
