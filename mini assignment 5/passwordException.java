 class passwordException  extends Exception {

    int pwdViol = 0;

    public passwordException(int conditionViolated)
    {
        System.out.println("Invalid Password: ");
        pwdViol = conditionViolated;
    }

    public String printMessage()
    {

        switch (pwdViol) {


            case 1:
                return ("Password length should be"
                        + " between 5 to 10 characters");

            case 2:
                return ("Password should contain"
                        + " at least one digit(0-9)");


            case 3:
                return ("Password should contain at "
                        + "least one special character");


            case 4:
                return ("Password should contain at"
                        + " least one uppercase letter(A-Z)");


            case 5:
                return ("Password should contain at"
                        + " least one lowercase letter(a-z)");
        }

        return ("");
    }
}

// Driver Class
 class PasswordValidator {


    public static void isValid(String password)
            throws passwordException
    {


        if (!((password.length() >= 5)
                && (password.length() <= 10))) {
            throw new passwordException(1);
        }


        if (true) {
            int count = 0;

            // check digits from 0 to 9
            for (int i = 0; i <= 9; i++) {


                String str1 = Integer.toString(i);

                if (password.contains(str1)) {
                    count = 1;
                }
            }
            if (count == 0) {
                throw new passwordException(2);
            }
        }

        // for special characters
        if (!(password.contains("@") || password.contains("#")
                || password.contains("!") || password.contains("~")
                || password.contains("$") || password.contains("%")
                || password.contains("^") || password.contains("&")
                || password.contains("*") || password.contains("(")
                || password.contains(")") || password.contains("-")
                || password.contains("+") || password.contains("/")
                || password.contains(":") || password.contains(".")
                || password.contains(", ") || password.contains("<")
                || password.contains(">") || password.contains("?")
                || password.contains("|"))) {
            throw new passwordException(3);
        }

        if (true) {
            int count = 0;


            for (int i = 65; i <= 90; i++) {


                char c = (char)i;

                String str1 = Character.toString(c);
                if (password.contains(str1)) {
                    count = 1;
                }
            }
            if (count == 0) {
                throw new passwordException(4);
            }
        }

        if (true) {
            int count = 0;


            for (int i = 90; i <= 122; i++) {

                // type casting
                char c = (char)i;
                String str1 = Character.toString(c);

                if (password.contains(str1)) {
                    count = 1;
                }
            }
            if (count == 0) {
                throw new passwordException(5);
            }
        }

    }

    // Driver code
    public static void main(String[] args)
    {

        String password1 = "Darshika";

        try {
            System.out.println("Is Password "
                    + password1 + " valid?");
            isValid(password1);
            System.out.println("Valid Password");
        }
        catch (passwordException e) {
            System.out.print(e.getMessage());
            System.out.println(e.printMessage());
        }

        String password2 = "Darshi009@";
        try {
            System.out.println("\nIs Password "
                    + password2 + " valid?");
            isValid(password2);
            System.out.println("Valid Password");
        }
        catch (passwordException e) {
            System.out.print(e.getMessage());
            System.out.println(e.printMessage());
        }
    }

}
