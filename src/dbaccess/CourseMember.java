
package dbaccess;

/**
 *
 * @author Andrew Gunn | amgunn1@hotmail.com
 */
public class CourseMember {
    
    private int memberId;
    private int courseId;

    /**
     *
     */
    public CourseMember() {
    }

    /**
     *
     * @param memberId
     * @param courseId
     */
    public CourseMember(int memberId, int courseId) {
        this.memberId = memberId;
        this.courseId = courseId;
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
     * @return the courseId
     */
    public int getCourseId() {
        return courseId;
    }

    /**
     * @param courseId the courseId to set
     */
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.memberId;
        hash = 11 * hash + this.courseId;
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
        final CourseMember other = (CourseMember) obj;
        if (this.memberId != other.memberId) {
            return false;
        }
        if (this.courseId != other.courseId) {
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
        return "CourseMember\n{\n" +
                "\nmemberId: " + memberId +
                "\ncourseId: " + courseId +
                "\n}\n";
    }
}
