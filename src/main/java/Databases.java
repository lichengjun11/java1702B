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
               CallableStatement cs = conn.prepareCall("{CALL reg(?,?,?,?)}");

               cs.setInt(1,1);
               cs.setString(2,"qwe");
               cs.setString(3,"123");
               // 第四个参数是out，获取时需先登记
               cs.registerOutParameter(4, Types.CHAR,10);
               cs.execute();
               String message = cs.getString(4);
               System.out.print(message);
           }
            } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //execProc();
        addProc();
    }
}

