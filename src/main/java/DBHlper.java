import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by lichengjun on 2017/7/27.
 */
public class DBHlper {
    private static Connection conn = null;
    public static int add(Account a) {
        Integer id = a.getUserid();
        String account = a.getAccount();
        String password = a.getPassword();
        String name = a.getName();
        String phone = a.getPhonenumber();
        String email = a.getEmail();

        conn = MySqlConnection.getInstance().getConnection();
        String sql1 = "INSERT INTO account VALUE (?,?,?)";
        String sql2 = "INSERT INTO information VALUE (?,?,?)";
    int i = -1;
        try {
            conn.setAutoCommit(false);
            PreparedStatement preparedStatement;
            preparedStatement = conn.prepareStatement(sql1);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, account);
            preparedStatement.setString(3, password);
             i = preparedStatement.executeUpdate();

            preparedStatement = conn.prepareStatement(sql2);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, phone);
            preparedStatement.setString(3, email);
            int j = preparedStatement.executeUpdate();
            conn.commit();
            preparedStatement.close();
            conn.close();

        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }

        return i;
    }


    public static void main(String[] args) {
        add(new Account());
    }
}
