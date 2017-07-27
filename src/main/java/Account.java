/**
 * Created by lichengjun on 2017/7/27.
 */
public class Account {
    private int userid;
    private String account;
    private String password;

    private String name;
    private String phonenumber;
    private String email;

    public Account() {
    }

    public Account(int userid, String account, String password, String name, String phonenumber, String email) {
        this.userid = userid;
        this.account = account;
        this.password = password;
        this.name = name;
        this.phonenumber = phonenumber;
        this.email = email;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
