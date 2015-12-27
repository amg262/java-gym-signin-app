
package dbaccess;

/**
 *
 * @author Andrew Gunn | amgunn1@hotmail.com
 */
public class MemberDTO {
    
    private int memberId;
    private String lastName;
    private String firstName;
    private String memType;
    private String memPayment;
    private String freeSession;
    private String memStatus;

    /**
     *
     */
    public MemberDTO() {
    }

    /**
     *
     * @param memberId
     * @param lastName
     * @param firstName
     * @param memType
     * @param freeSession 
     * @param memPayment
     * @param memStatus
     */
    public MemberDTO(int memberId, String lastName, String firstName,
            String memType,String freeSession, String memPayment, String memStatus) {
        
        this.memberId = memberId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.memType = memType;
        this.memPayment = memPayment;
        this.freeSession = freeSession;
        this.memStatus = memStatus;
    }

    /**
     * @return the memberId
     */
    public int getMemberId() {
        return memberId;
    }

    /**
     * @param memberId the memberId to set
     */
    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the memType
     */
    public String getMemType() {
        return memType;
    }

    /**
     * @param memType the memType to set
     */
    public void setMemType(String memType) {
        this.memType = memType;
    }

    /**
     * @return the memPayment
     */
    public String getMemPayment() {
        return memPayment;
    }

    /**
     * @param memPayment the memPayment to set
     */
    public void setMemPayment(String memPayment) {
        this.memPayment = memPayment;
    }
    
    /**
     * @return the freeSession
     */
    public String getFreeSession() {
        return freeSession;
    }

    /**
     * @param freeSession the freeSession to set
     */
    public void setFreeSession(String freeSession) {
        this.freeSession = freeSession;
    }
    

    /**
     * @return the memStatus
     */
    public String getMemStatus() {
        return memStatus;
    }

    /**
     * @param memStatus the memStatus to set
     */
    public void setMemStatus(String memStatus) {
        this.memStatus = memStatus;
    }
    
    

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.memberId;
        return hash;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MemberDTO other = (MemberDTO) obj;
        if (this.memberId != other.memberId) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "MemberDTO\n{\n" +
                "\nmemberId: " + memberId +
                "\nlastName: " + lastName +
                "\nfirstName: " + firstName +
                "\nmemType: " + memType +
                "\nmemPayment: " + memPayment +
                "\nfreeSession: " + freeSession +
                "\nmemStatus: " + memStatus +
                "\n}\n";
    }
}


