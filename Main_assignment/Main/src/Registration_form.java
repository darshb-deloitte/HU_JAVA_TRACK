import java.io.IOException;
import java.util.Scanner;

public class Registration_form {

    public String[] registration() throws IOException {

        Scanner sc = new Scanner(System.in);
        boolean boo;
        String[] res = new String[100];

        System.out.println("Enter Username:");
        String user_name = sc.nextLine();

        System.out.println("Enter Password:");
        String pass_word = sc.nextLine();

        System.out.println("Re-enter Password");
        String pass_word1 = sc.nextLine();

        res[0] = user_name;
        res[1] = pass_word;

        try {
            if (!pass_word.equals(pass_word1)) {
                throw new IOException("Password Mismatch");
            }

            else{
                System.out.println("Registration successful");
                res[0] = user_name;
                res[1] = pass_word;
            }
        }

        catch(IOException e){
            System.out.println("Registration unsuccessful");
        }

        return res;
    }
}
