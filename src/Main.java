import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String []args) throws IOException {

        Scanner sc = new Scanner(System.in);

        String username = null ;
        String password = null;
        String valid = "Invalid";

        boolean validate = false;
        int op,option;
        String[] res = new String[100];
        System.out.println("****** Welcome to User Database ******");

        do {
            System.out.println("1. Login");
            System.out.println("2. Registration");
            System.out.println("3. Exit");
            System.out.println("Select an option :");

            op = sc.nextInt();

            switch (op) {
                case 1: {
                    if (username != null || password != null) {
                        Login log_in = new Login();
                        validate = log_in.login_page(username, password);
                        break;
                    }

                    else{
                        System.out.println("Please Register before logging in");
                        break;
                    }

                }

                case 2: {
                    Registration reg_form = new Registration();
                    res = reg_form.registration(username,password);

                    if(res[2] == "UserExists"){
                        System.out.println("User Already Exists");
                        break;
                    }

                    if(res[2] == "valid") {
                        username = res[0];
                        password = res[1];
                        valid = res[2];
                    }

//                    if (valid == "valid") {
//                        System.out.println("Please Login to continue");
//                        Login log_in = new Login();
//                        validate = log_in.login_page(username, password);
//                        break;
//                    }

                    break;
                }

                case 3:{
                    System.out.println("\nYou have chosen EXIT !!");
                    sc.close();
                    System.exit(0);
                    break;
                }

                default:
                    System.out.println("Invalid choice");
            }

//            System.out.println(validate);
            if (validate) {
                EmpData employee = new EmpData();

                employee.emp();
                validate = false;
            }
        }while(true);

    }
}
