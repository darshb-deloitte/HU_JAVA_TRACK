import java.io.IOException;
import java.util.Scanner;

public class Registration {

    public String[] registration(String username, String password) throws IOException {

        Scanner sc = new Scanner(System.in);
        boolean boo;
        char ch;
        boolean capitalFlag = false;
        boolean lowerCaseFlag = false;
        boolean numberFlag = false;
        boolean spl_char_flag = false;
        boolean flag = false;
        String[] res = new String[100];

        System.out.println("Enter Username:");
        String user_name = sc.nextLine();

        System.out.println("Password should be: ");

        System.out.println("Password should be in a range of 5 to 10 characters with below combination\n" +
                "At least one Uppercase alphabet\n" +
                "At least one Lowercase alphabet\n" +
                "At least one special characters “@ #  &  % * ! ”\n" +
                "At least one digit\n");

        System.out.println("Enter Password:");
        String pass_word = sc.nextLine();

        int length = String.valueOf(pass_word).length();

        for(int i=0;i < length;i++) {
            ch = pass_word.charAt(i);

            if( Character.isDigit(ch)) {
                numberFlag = true;
            }

            else if (Character.isUpperCase(ch)) {
                capitalFlag = true;
            }

            else if (Character.isLowerCase(ch)) {
                lowerCaseFlag = true;
            }

            else if ((ch == '@') || (ch == '#') || (ch == '&') || (ch == '%') || (ch == '*') || (ch == '!')){
                spl_char_flag = true;
            }

            if(numberFlag && capitalFlag && lowerCaseFlag && spl_char_flag)
                flag = true;
        }

        if(((length < 5) && (length > 10)) || (flag == false )){
            System.out.println("Invalid password");
            res[2] = "Invalid";
            return res;
        }

        if(user_name.equals(username) && pass_word.equals(password)){
            res[2] = "UserExists";
            return res;
        }

        System.out.println("Re-enter Password");
        String pass_word1 = sc.nextLine();

        try {
            if (!pass_word.equals(pass_word1)) {
                throw new IOException("Password Mismatch");
            }

            else{
                System.out.println("Registration successful");
                res[0] = user_name;
                res[1] = pass_word;
                res[2] = "valid";
            }
        }

        catch(IOException e){
            System.out.println("Registration unsuccessful");
        }

        return res;
    }
}
