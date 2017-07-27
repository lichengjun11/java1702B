import java.util.Scanner;

/**
 * Created by lichengjun on 2017/7/27.
 */
public class Demo {
    static Scanner sc = new Scanner(System.in);
    public static void reg(){
        System.out.println("注册帐号\t  请输入帐号\n");
        String account = sc.nextLine();
        System.out.println("输入密码");
        String password = sc.nextLine();
        System.out.println("输入名字");
        String name = sc.nextLine();
        System.out.println("输入手机号");
        String phonenuber = sc.nextLine();
        System.out.println("输入邮箱");
        String email = sc.nextLine();

        int i = DBHlper.add(new Account(0,account,password,name,phonenuber,email));
        if(i>0){
            System.out.println("注册成功");
        }else {
            System.out.println("注册失败");
        }
    }

    public static void main(String[] args) {
        reg();
    }
}
