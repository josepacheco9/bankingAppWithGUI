package mp;

public class Connect {
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String HOSTNAME = "localhost";
    public static final String PORT = "3306";
    public static final String DATABASE_NAME = "bank";
    public static final String USERNAME = "root";
    public static final String PASSWORD  = "root";
    public static final String CONNECTION_STRING =
            "jdbc:mysql://"+Connect.HOSTNAME+":"+Connect.PORT
            +"/"+Connect.DATABASE_NAME;
    //public static final String CONNECTION_STRING =
    //"jdbc:oracle:thin:@"+Connect.PORT+"/"+Connect.DATABASE_NAME;
}
