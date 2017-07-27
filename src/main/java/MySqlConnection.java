import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by lichengjun on 2017/7/27.
 */
public class MySqlConnection {
    private static final MySqlConnection connection = new MySqlConnection();
    // 明确要连接的数据库
    private String connectionString = "jdbc:mysql://localhost:3306/1702B";
    private String BaseUserName = "root";
    private String BaseUserpwd = "system";
    private final int DB_Version = 1;

    // 数据库连接对象
    private Connection mySqlconnection = null;

    public String getConnectionString() {
        return connectionString;
    }

    public String getBaseUserName() {
        return BaseUserName;
    }

    public String getBaseUserpwd() {
        return BaseUserpwd;
    }

    public int getDB_Version() {
        return DB_Version;
    }

    // 获取mysql连接对象
    public Connection getConnection(){
        if(mySqlconnection != null){
            mySqlconnection = null;
        }
        try {
            Class.forName("com.mysql.jdbc.Driver");
            mySqlconnection = DriverManager.getConnection(connectionString,BaseUserName,BaseUserpwd);
            if(mySqlconnection.isClosed()){
                // 如果连接关闭，再进行一次连接
                mySqlconnection = DriverManager.getConnection(connectionString,BaseUserName,BaseUserpwd);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    return mySqlconnection;
    }

    public MySqlConnection(){

    }
    public static MySqlConnection getInstance(){
        return connection;
    }
}
