import java.sql.*;

/**
 * Created by lichengjun on 2017/7/28.
 */
public class Databases {
    private static Connection conn = null;
    private static final String URL = "jdbc:mysql://localhost:3306/reg";
    private static final String USER = "root";
    private static final String PASSWORD = "system";
    private static final int DB_Version = 1;

    // 不带参数的存储过程
    public static void execProc(){
        int[] i;

            // 不需要创建对象
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            if (!conn.isClosed()){
                // 如果连接关闭，在进行一次连接
                conn = DriverManager.getConnection(URL,USER,PASSWORD);
                //  调用mysql存储过程，｛call 存储过程名称【参数】｝
                CallableStatement cs = conn.prepareCall("{CALL showdata()}");
                ResultSet resultSet = cs.executeQuery();
                while (resultSet.next()){
                    System.out.println(resultSet.getString(2));
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void addProc(){
        int[] i;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            if (!conn.isClosed()){
                conn = DriverManager.getConnection(URL,USER,PASSWORD);
                CallableStatement cs = conn.prepareCall("{CALL showdata(?,?,?,?)}");
                cs.setInt(1,11);
                cs.setString(2,"tom");
                cs.setString(3,"123");
                // 登记输出参数运行的时候从存取过程中读取out标签的变量
                /*
                    参数：
                    1：下标
                    2：在数据库中的类型
                    java.sql.Types

                    执行存储过程的时候
                    out标签和inout标签的数据可以直接通过登记的方式读取到
                    java中，如果读取存储过程的输出参数，必须要进行登记
                    1.数据库的存储过程，必须要将数据返回出来
                    2.mysql sql-server oracle sysbase 在调用带返回参数的存储过程
                        的时候需要使用execute方法来执行，才能获取数据
                     3.SQLite（嵌入式数据库，android，IOS，symbian，meego，黑莓等所有移动终端）
                         只需要登记输出的返回结果，即可执行
                     4.调用存储过程的时候，要首先确定  存储过程名称
                        以及所在的数据库名称
                        存储过程的参数后面不要加空格，别名
                 */
                cs.registerOutParameter(4, Types.CHAR,12);
                cs.execute();
                String message = cs.getNString(4);
                System.out.println(message);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        execProc();
       // addProc();
    }
}

