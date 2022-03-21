import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String []args) throws IOException {

        Scanner sc = new Scanner(System.in);

        String username = "darshi@deloitte.com";
        String password = "darshi@15";

        System.out.println(username);
        System.out.println(password);

        boolean validate = false;
        int op,option;
        String[] res = new String[100];
        System.out.println("****** Welcome to User Database ******");
        System.out.println("1. Login");
        System.out.println("2. Registration");
        System.out.println("Select an option :");

        op = sc.nextInt();

        switch (op)
        {
            case 1: {
                Login log_in = new Login();
                validate = log_in.login_page(username, password);
                break;

            }

            case 2:{
                Registration_form reg_form = new Registration_form();
                res = reg_form.registration();
                username = res[0];
                password = res[1];

                System.out.println("Please Login to continue");
                Login log_in = new Login();
                validate = log_in.login_page(username, password);
                break;
            }

            default: System.out.println("Invalid choice");
        }

        System.out.println(validate);
        if(validate){
            EmpData employee = new EmpData();

            employee.emp();
        }

    }
}