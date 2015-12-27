
package dbaccess;

import java.util.List;

/**
 *
 * @author Andrew Gunn | amgunn1@hotmail.com
 */
public interface I_CourseDAO {
    
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
    public abstract List<Course> retrieveAllCourses() throws DataAccessException;
    
    /**
     *
     * @param id 
     * @return
     * @throws DataAccessException
     */
    public abstract Course retreiveCourseById(String id) throws DataAccessException;
    
    
    /**
     *
     * @param keyword
     * @return
     * @throws DataAccessException
     */
    public abstract List<Course> retrieveCourseByKeyword(String keyword) throws DataAccessException;
    
    /**
     *
     * @param course 
     * @throws DataAccessException
     */
    public abstract void saveCourse(Course course) throws DataAccessException;
    
    /**
     *
     * @param course 
     * @throws DataAccessException
     */
    public abstract void deleteCourse(Course course) throws DataAccessException;

}
