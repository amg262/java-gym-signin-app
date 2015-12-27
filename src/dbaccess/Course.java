
package dbaccess;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Andrew Gunn | amgunn1@hotmail.com
 */
public class Course {
    
    private int id;
    private int instructorId;
    private int typeId;
    private String title;
    private int capacity;
    private Date startDate;
    private Time startTime;
    private Date endDate;
    private Time endTime;

    /**
     *
     */
    public Course() {
    }

    /**
     *
     * @param id
     * @param instructorId
     * @param typeId
     * @param title
     * @param capacity
     * @param startDate
     * @param startTime
     * @param endDate
     * @param endTime
     */
    public Course(int id, int instructorId, int typeId, String title, int capacity,
            Date startDate, Time startTime, Date endDate, Time endTime) {
        
        this.id = id;
        this.instructorId = instructorId;
        this.typeId = typeId;
        this.title = title;
        this.capacity = capacity;
        this.startDate = startDate;
        this.startTime = startTime;
        this.endDate = endDate;
        this.endTime = endTime;
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
     * @return the instructorId
     */
    public int getInstructorId() {
        return instructorId;
    }

    /**
     * @param instructorId the instructorId to set
     */
    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    /**
     * @return the typeId
     */
    public int getTypeId() {
        return typeId;
    }

    /**
     * @param typeId the typeId to set
     */
    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * @param capacity the capacity to set
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the startTime
     */
    public Time getStartTime() {
        return startTime;
    }

    /**
     * @param startTime the startTime to set
     */
    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    /**
     * @return the endDate
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the endTime
     */
    public Time getEndTime() {
        return endTime;
    }

    /**
     * @param endTime the endTime to set
     */
    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id;
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
        final Course other = (Course) obj;
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
        return "Course\n{\n" +
                "\nid: " + id +
                "\ninstructorId: " + instructorId +
                "\ntypeId: " + typeId +
                "\ntitle: " + title +
                "\ncapacity: " + capacity +
                "\nstartDate: " + startDate +
                "\nstartTime: " + startTime +
                "\nendDate: " + endDate +
                "\nendTime: " + endTime +
                "\n}\n";
    }
}
