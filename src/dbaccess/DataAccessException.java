package dbaccess;

/**
 *
 * @author Andy
 */
public class DataAccessException extends Exception {
    
    private static final String MSG = "Error in accessing Data...";
    
    /**
     *
     * @param msg
     */
    public DataAccessException(String msg) {
        super(msg);
    }
    
    /**
     *
     * @param msg
     * @param cause
     */
    public DataAccessException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
