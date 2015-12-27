
package dbaccess;

import java.util.List;

/**
 *
 * @author Andrew Gunn | amgunn1@hotmail.com
 */
public class CourseService {
    
    private I_CourseDAO courseDAO;
    
    
    /**
     *
     */
    public CourseService() {
        I_DBAccessor db = new DBAccessor();
        courseDAO = new CourseDAO(db);
    }
    
    
    /**
     *
     * @return
     * @throws DataAccessException
     */
    public List<Course> getAllCourses()  throws DataAccessException {
        return courseDAO.retrieveAllCourses();
    }
    
    /**
     *
     * @param id
     * @return
     * @throws DataAccessException
     */
    public Course getCourseById(String id)  throws DataAccessException {
        return courseDAO.retreiveCourseById(id);
    }
    
    /**
     *
     * @param keyword
     * @return
     * @throws DataAccessException
     */
    public List<Course> getCourseByKeyword(String keyword) throws DataAccessException {
        return courseDAO.retrieveCourseByKeyword(keyword);
    }
    
    /**
     *
     * @param course
     * @throws DataAccessException
     */
    public void saveCourse(Course course) throws DataAccessException{
        courseDAO.saveCourse(course);
    }
    
    /**
     *
     * @param course
     * @throws DataAccessException
     */
    public void deleteCourse(Course course) throws DataAccessException{
        courseDAO.saveCourse(course);
    }
    
    
    /**
     *
     * @param args
     * @throws DataAccessException
     */
    public static void main(String[] args) throws DataAccessException {
        
        CourseService cs = new CourseService();
        Course course = new Course();
        
        System.out.println(cs.getAllCourses());
        
    }
    
}
