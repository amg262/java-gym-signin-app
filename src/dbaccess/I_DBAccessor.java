package dbaccess;


import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author agunn1
 */
public interface I_DBAccessor {
    
    /**
     *
     * @param driverClassName
     * @param url
     * @param username
     * @param password
     * @throws IllegalArgumentException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public abstract void openConnection(String driverClassName, String url, String username, String password)
            throws IllegalArgumentException, ClassNotFoundException, SQLException;
    
    /**
     *
     * @throws SQLException
     */
    public abstract void closeConnection() throws SQLException;

    /**
     *
     * @param sqlString
     * @param closeConnection
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public abstract List retrieveRecords(String sqlString, boolean closeConnection)
            throws SQLException, Exception;
    
    
    
    /**
     *
     * @param table
     * @param primaryKeyField
     * @param keyValue
     * @param closeConnection
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public abstract Map retrieveRecordByID(String table, String primaryKeyField, Object keyValue, boolean closeConnection)
	throws SQLException, Exception;
    
    
    
    /**
     *
     * @param tableName
     * @param colDescriptors
     * @param colValues
     * @param closeConnection
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public abstract boolean insertRecord(String tableName, List colDescriptors, List colValues, boolean closeConnection)
	throws SQLException, Exception;
    
    
    /**
     *
     * @param tableName
     * @param colDescriptors
     * @param colValues
     * @param whereField
     * @param whereValue
     * @param closeConnection
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public int updateRecords(String tableName, List colDescriptors, List colValues,
			 String whereField, Object whereValue, boolean closeConnection)
			 throws SQLException, Exception;
    
    
    /**
     *
     * @param tableName
     * @param whereField
     * @param whereValue
     * @param closeConnection
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public abstract int deleteRecords(String tableName, String whereField, Object whereValue, boolean closeConnection)
	throws SQLException, Exception;
    
}


