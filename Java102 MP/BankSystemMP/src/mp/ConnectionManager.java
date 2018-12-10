package mp;

import com.mysql.jdbc.Connection;
import java.sql.*;
import java.sql.DriverManager;

public final class ConnectionManager {
    public Connection conn;
    private Statement statement;
    public static ConnectionManager db;
    
    private ConnectionManager() {
        String url= "jdbc:mysql://localhost:3306/";
        String dbName = "bank";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "root";
        try {
            Class.forName(driver).newInstance();
            this.conn = (Connection)DriverManager.getConnection(url+dbName,userName,password);
            //System.out.println("CONNECTED SUCCESSFULLY!");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     *
     * @return MysqlConnect Database connection object
     */
    public static synchronized ConnectionManager getDbCon() {
        if ( db == null ) {
            db = new ConnectionManager();
            //System.out.println("new CONN!!");
        }
        return db;
 
    }
    /**
     *
     * @param query String The query to be executed
     * @return a ResultSet object containing the results or null if not available
     * @throws SQLException
     */
    public ResultSet query(String query) throws SQLException{
        statement = db.conn.createStatement();
        ResultSet res = statement.executeQuery(query);
        return res;
    }
    /**
     * @desc Method to insert data to a table
     * @param insertQuery String The Insert query
     * @return boolean
     * @throws SQLException
     */
    public int insert(String insertQuery) throws SQLException {
        statement = db.conn.createStatement();
        int result = statement.executeUpdate(insertQuery);
        return result;
 
    }
 
}