
package dbaccess;

import java.util.Date;

/**
 *
 * Contains all the fields that are in Member table in database
 * 
 * @author Andrew Gunn | amgunn1@hotmail.com
 */
public class Member {
    
    private int id;
    private int memType;
    private int freeSession;
    private int memStatus;
    private int memPayment;
    private String lastName;
    private String firstName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String email;
    private Date joinDate;

    /**
     *
     */
    public Member() {
    }

    /**
     *
     * @param id
     */
    public Member(int id) {
        this.id = id;
    }

    /**
     *
     * @param id
     * @param memType
     * @param freeSession
     * @param memStatus
     * @param memPayment
     * @param lastName
     * @param firstName
     * @param address
     * @param city
     * @param state
     * @param zip
     * @param phone
     * @param email
     * @param joinDate
     */
    public Member(int id, int memType, int freeSession,int memPayment, int memStatus,
            String lastName, String firstName,
            String address, String city, String state, String zip,
            String phone, String email, Date joinDate) {
        
        this.id = id;
        this.memType = memType;
        this.freeSession = freeSession;
        this.memStatus = memStatus;
        this.memPayment = memPayment;
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
        this.joinDate = joinDate;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the memType
     */
    public int getMemType() {
        return memType;
    }

    /**
     * @param memType the memType to set
     */
    public void setMemType(int memType) {
        this.memType = memType;
    }

    /**
     * @return the freeSession
     */
    public int getFreeSession() {
        return freeSession;
    }

    /**
     * @param freeSession the freeSession to set
     */
    public void setFreeSession(int freeSession) {
        this.freeSession = freeSession;
    }

    /**
     * @return the memStatus
     */
    public int getMemStatus() {
        return memStatus;
    }

    /**
     * @param memStatus the memStatus to set
     */
    public void setMemStatus(int memStatus) {
        this.memStatus = memStatus;
    }

    /**
     * @return the memPayment
     */
    public int getMemPayment() {
        return memPayment;
    }

    /**
     * @param memPayment the memPayment to set
     */
    public void setMemPayment(int memPayment) {
        this.memPayment = memPayment;
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
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * @param zip the zip to set
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the joinDate
     */
    public Date getJoinDate() {
        return joinDate;
    }

    /**
     * @param joinDate the joinDate to set
     */
    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.id;
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
        final Member other = (Member) obj;
        if (this.id != other.id) {
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
        return "\nMember\n{\n" +
                "id: " + id +
                "\nmemType: " + memType +
                "\nfreeSession: " + freeSession +
                "\nmemPayment: " + memPayment +
                "\nmemStatus: " + memStatus +
                "\nlastName: " + lastName +
                "\nfirstName: " + firstName +
                "\naddress: " + address +
                "\ncity: " + city +
                "\nstate: " + state +
                "\nzip: " + zip +
                "\nphone: " + phone +
                "\nemail: " + email +
                "\njoinDate: " + joinDate +
                "\n}\n";
    }

    
    
    
}