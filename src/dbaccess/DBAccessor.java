package dbaccess;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


/**
 *
 * @author Andy
 */
public class DBAccessor implements I_DBAccessor {

        private Connection conn;

        /**
         *
         */
        public DBAccessor(){}

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
        @Override
        public void openConnection(String driverClassName, String url, String username, String password)
                throws IllegalArgumentException, ClassNotFoundException, SQLException {

            String msg = "Error in URL";
            if (url == null || url.length() == 0) throw new IllegalArgumentException(msg);
            username = (username == null) ? "" : username;
            password = (password == null) ? "" : password;
            Class.forName(driverClassName);

            conn = DriverManager.getConnection(url, username, password);

        }

        /**
         *
         * @throws SQLException
         */
        @Override
        public void closeConnection() throws SQLException {
            conn.close();
        }

        /**
         *
         * @param sqlString
         * @param closeConnection
         * @return list
         * @throws SQLException
         * @throws Exception
         */
        @Override
        public List retrieveRecords(String sqlString, boolean closeConnection)
                throws SQLException, Exception {

            Statement stmnt = null;
            ResultSet resultSet = null;
            ResultSetMetaData metaData = null;
            List list = new ArrayList();
            Map records = null;

            //finally will always close connection
            try {
                stmnt = conn.createStatement();
                resultSet = stmnt.executeQuery(sqlString);
                metaData = resultSet.getMetaData();
                int fields = metaData.getColumnCount();

                while (resultSet.next()){
                    records = new HashMap();
                    for (int i=1; i <= fields; i++){
                        try {
                            records.put(metaData.getColumnName(i), resultSet.getObject(i));
                        } catch (NullPointerException npe){

                        } //end of 2nd catch
                    } ///End of for
                    list.add(records);
                } // end of while

            } catch (SQLException sqle){
                throw sqle;
            } catch (Exception e) {
                throw e;
            } finally {
                try {
                    stmnt.close();
                    if (closeConnection){
                        conn.close();
                    } // end of if
                } catch (SQLException sqle2){
                    throw sqle2;
                } // end of try
            } // end of finally

            return list;
        }

        /**
         *
         * @param table
         * @param primaryKeyField
         * @param keyValue
         * @param closeConnection
         * @return record
         * @throws SQLException
         * @throws Exception
         */
        @Override
        public Map retrieveRecordByID(String table, String primaryKeyField, Object keyValue, boolean closeConnection)
                throws SQLException, Exception {

            Statement stmnt = null;
            ResultSet resultSet = null;
            ResultSetMetaData metaData = null;
            final Map record = new HashMap(); //Final?

            //finally will always close connection
            try {
                stmnt = conn.createStatement();
                String sql2;

                if (keyValue instanceof String){
                    sql2 = "= '" + keyValue + "'";

                } else {
                    sql2 = "=" + keyValue;
                }

                final String sql = "Select * From " + table + " Where " + primaryKeyField + sql2;

                resultSet = stmnt.executeQuery(sql);
                metaData = resultSet.getMetaData();
                metaData.getColumnCount();
                final int fields = metaData.getColumnCount();

                if (resultSet.next()){
                    for (int i=1; i <= fields; i++){
                        record.put(metaData.getColumnName(i), resultSet.getObject(i));
                    } //end of for
                } //end of if

            } catch (SQLException sqle){
                throw sqle;
            } catch (Exception e){
                throw e;
            } finally {

                try {
                    stmnt.close();
                    if (closeConnection) {
                        conn.close();
                    } 
                } catch (SQLException sqle2){
                        throw sqle2;
                    } //end of try
                } //end of finally


            return record;
        }

        public boolean insertRecord(String tableName, List colDescriptors, List colValues, boolean closeConnection)
	throws SQLException, Exception
	{
		PreparedStatement pstmt = null;
		int recsUpdated = 0;

		// do this in an excpetion handler so that we can depend on the
		// finally clause to close the connection
		try {
			pstmt = buildInsertStatement(conn,tableName,colDescriptors);

			final Iterator i=colValues.iterator();
			int index = 1;
			while( i.hasNext() ) {
				final Object obj=i.next();
				if(obj instanceof String){
					pstmt.setString( index++,(String)obj );
				} else if(obj instanceof Integer ){
					pstmt.setInt( index++,((Integer)obj).intValue() );
				} else if(obj instanceof Long ){
					pstmt.setLong( index++,((Long)obj).longValue() );
				} else if(obj instanceof Double ){
					pstmt.setDouble( index++,((Double)obj).doubleValue() );
				} else if(obj instanceof java.sql.Date ){
					pstmt.setDate(index++, (java.sql.Date)obj );
				} else if(obj instanceof Boolean ){
					pstmt.setBoolean(index++, ((Boolean)obj).booleanValue() );
				} else {
					if(obj != null) pstmt.setObject(index++, obj);
				}
			}
			recsUpdated = pstmt.executeUpdate();

		} catch (SQLException sqle) {
			throw sqle;
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				pstmt.close();
				if(closeConnection) conn.close();
			} catch(SQLException e) {
				throw e;
			} // end try
		} // end finally

		if(recsUpdated == 1){
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Updates one or more records in a table based on a single, matching field value.
	 * 
	 * @param tableName - a <code>String</code> representing the table name
	 * @param colDescriptors - a <code>List</code> containing the column descriptors for
	 * the fields that can be updated.
	 * @param colValues - a <code>List</code> containing the values for the fields that
	 * can be updated.
	 * @param whereField - a <code>String</code> representing the field name for the
	 * search criteria.
	 * @param whereValue - an <code>Object</code> containing the value for the search criteria.
	 * @param closeConnection - true if connection should be closed automatically; if
	 * false, connection must be explicitly closed using the closeConnection method.
	 * @return an <code>int</code> containing the number of records updated.
	 * @throws SQLException if database access error or illegal sql
	 * @throws Exception for all other problems
	 */
	public int updateRecords(String tableName, List colDescriptors, List colValues,
							 String whereField, Object whereValue, boolean closeConnection)
							 throws SQLException, Exception
	{
		PreparedStatement pstmt = null;
		int recsUpdated = 0;

		// do this in an excpetion handler so that we can depend on the
		// finally clause to close the connection
		try {
			pstmt = buildUpdateStatement(conn,tableName,colDescriptors,whereField);

			final Iterator i=colValues.iterator();
			int index = 1;
			boolean doWhereValueFlag = false;
			Object obj = null;

			while( i.hasNext() || doWhereValueFlag) {
				if(!doWhereValueFlag){ obj = i.next();}

				if(obj instanceof String){
					pstmt.setString( index++,(String)obj );
				} else if(obj instanceof Integer ){
					pstmt.setInt( index++,((Integer)obj).intValue() );
				} else if(obj instanceof Long ){
					pstmt.setLong( index++,((Long)obj).longValue() );
				} else if(obj instanceof Double ){
					pstmt.setDouble( index++,((Double)obj).doubleValue() );
				} else if(obj instanceof java.sql.Timestamp ){
					pstmt.setTimestamp(index++, (java.sql.Timestamp)obj );
				} else if(obj instanceof java.sql.Date ){
					pstmt.setDate(index++, (java.sql.Date)obj );
				} else if(obj instanceof Boolean ){
					pstmt.setBoolean(index++, ((Boolean)obj).booleanValue() );
				} else {
					if(obj != null) pstmt.setObject(index++, obj);
				}

				if(doWhereValueFlag){ break;} // only allow loop to continue one time
				if(!i.hasNext() ) {          // continue loop for whereValue
					doWhereValueFlag = true;
					obj = whereValue;
				}
			}

			recsUpdated = pstmt.executeUpdate();

		} catch (SQLException sqle) {
			throw sqle;
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				pstmt.close();
				if(closeConnection) conn.close();
			} catch(SQLException e) {
				throw e;
			} // end try
		} // end finally

		return recsUpdated;
	}
    
    /**
     *
     * @param tableName
     * @param whereField
     * @param whereValue
     * @param closeConnection
     * @return recordsDeleted
     * @throws SQLException
     * @throws Exception
     */
    @Override
    public int deleteRecords(String tableName, String whereField, Object whereValue, boolean closeConnection)
            throws SQLException, Exception {
        
        PreparedStatement prepStmnt = null;
        int recordsDeleted = 0;
        
        //finally will close connection
        try {
            prepStmnt = buildDeleteStatement(conn, tableName, whereField);
            
            //will delete records if null
            if (whereField != null){
                
                if (whereValue instanceof String){
                    prepStmnt.setString(1, (String)whereValue);
                    
                } else if (whereValue instanceof Integer) {
                    prepStmnt.setInt(1, ((Integer)whereValue).intValue());
                    
                } else if (whereValue instanceof Long) {
                    prepStmnt.setLong(1, ((Long)whereValue).longValue());
                    
                } else if (whereValue instanceof Short) {
                    prepStmnt.setShort(1, ((Short)whereValue).shortValue());
                    
                } else if (whereValue instanceof java.sql.Time) {
                    prepStmnt.setTime(1, ((java.sql.Time)whereValue));     
                    
                } else if (whereValue instanceof java.sql.Timestamp) {
                    prepStmnt.setTimestamp(1, ((java.sql.Timestamp)whereValue));
                    
                } else if (whereValue instanceof Double) {
                    prepStmnt.setDouble(1, ((Double)whereValue).doubleValue());
                    
                } else if (whereValue instanceof java.sql.Date) {
                    prepStmnt.setDate(1, ((java.sql.Date)whereValue));
                    
                } else if (whereValue instanceof Boolean) {
                    prepStmnt.setBoolean(1, ((Boolean)whereValue).booleanValue());
                    
                } else if (whereValue instanceof Float) {
                    prepStmnt.setFloat(1, ((Float)whereValue).floatValue());
                    
                } else {
                    
                    if (whereValue != null){
                        prepStmnt.setObject(1, whereValue);
                    }//end of if
                }//end of else
            }//end of if
            
            recordsDeleted = prepStmnt.executeUpdate();
        } catch (SQLException sqle) {
            throw sqle;
        } catch (Exception e){
            throw e;
        } finally {
            try {
                prepStmnt.close();
                if (closeConnection){
                    conn.close();
                }//end of if
                
            } catch (SQLException sqle2){
                throw sqle2;
            }//end of try     
        }//end of finally
        
        return recordsDeleted;
    }

/*
	 * Builds a java.sql.PreparedStatement for an sql insert
	 * @param conn - a valid connection
	 * @param tableName - a <code>String</code> representing the table name
	 * @param colDescriptors - a <code>List</code> containing the column descriptors for
	 * the fields that can be inserted.
	 * @return java.sql.PreparedStatement
	 * @throws SQLException
	 */
	private PreparedStatement buildInsertStatement(Connection conn_loc, String tableName, List colDescriptors)
	throws SQLException {
		StringBuffer sql = new StringBuffer("INSERT INTO ");
		(sql.append(tableName)).append(" (");
		final Iterator i=colDescriptors.iterator();
		while( i.hasNext() ) {
			(sql.append( (String)i.next() )).append(", ");
		}
		sql = new StringBuffer( (sql.toString()).substring( 0,(sql.toString()).lastIndexOf(", ") ) + ") VALUES (" );
		for( int j = 0; j < colDescriptors.size(); j++ ) {
			sql.append("?, ");
		}
		final String finalSQL=(sql.toString()).substring(0,(sql.toString()).lastIndexOf(", ")) + ")";
		//System.out.println(finalSQL);
		return conn_loc.prepareStatement(finalSQL);
	}

	/*
	 * Builds a java.sql.PreparedStatement for an sql update using only one where clause test
	 * @param conn - a JDBC <code>Connection</code> object
	 * @param tableName - a <code>String</code> representing the table name
	 * @param colDescriptors - a <code>List</code> containing the column descriptors for
	 * the fields that can be updated.
	 * @param whereField - a <code>String</code> representing the field name for the
	 * search criteria.
	 * @return java.sql.PreparedStatement
	 * @throws SQLException
	 */
	private PreparedStatement buildUpdateStatement(Connection conn_loc, String tableName,
												   List colDescriptors, String whereField)
	throws SQLException {
		StringBuffer sql = new StringBuffer("UPDATE ");
		(sql.append(tableName)).append(" SET ");
		final Iterator i=colDescriptors.iterator();
		while( i.hasNext() ) {
			(sql.append( (String)i.next() )).append(" = ?, ");
		}
		sql = new StringBuffer( (sql.toString()).substring( 0,(sql.toString()).lastIndexOf(", ") ) );
		((sql.append(" WHERE ")).append(whereField)).append(" = ?");
		final String finalSQL=sql.toString();
		return conn_loc.prepareStatement(finalSQL);
	}

	/*
	 * Builds a java.sql.PreparedStatement for an sql delete using only one where clause test
	 * @param conn - a JDBC <code>Connection</code> object
	 * @param tableName - a <code>String</code> representing the table name
	 * @param whereField - a <code>String</code> representing the field name for the
	 * search criteria.
	 * @return java.sql.PreparedStatement
	 * @throws SQLException
	 */
	private PreparedStatement buildDeleteStatement(Connection conn_loc, String tableName, String whereField)
	throws SQLException {
		final StringBuffer sql=new StringBuffer("DELETE FROM ");
		sql.append(tableName);

		// delete all records if whereField is null
		if(whereField != null ) {
			sql.append(" WHERE ");
			(sql.append( whereField )).append(" = ?");
		}

		final String finalSQL=sql.toString();
//		System.out.println(finalSQL);
		return conn_loc.prepareStatement(finalSQL);
	}
}