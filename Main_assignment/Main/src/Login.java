import java.util.Scanner;

public class Login {
    public boolean login_page(String username,String password){

        Scanner sc = new Scanner(System.in);

        System.out.println("--- Welcome to login page ---");
        System.out.println("Enter Username:");
        String user_name = sc.nextLine();

        System.out.println("Enter Password:");
        String pass_word = sc.nextLine();

        System.out.println(username);
        System.out.println(password);

        if ((user_name.equals(username)) && (pass_word.equals(password))) {
            return (true);
        }
        else{
            return(false);
        }
    }
}