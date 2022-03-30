import java.io.*;
import java.util.*;

@SuppressWarnings("serial")
class Employee implements Serializable{

    int id;
    String name;
    int age;
    String company_name;
    String designation;
    float salary;
    long contact_no;
    String email_id;

    public Employee(int id, String name, float salary, long contact_no, String email_id, int age,
                    String company_name, String designation)
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.company_name = company_name;
        this.designation = designation;
        this.salary = salary;
        this.contact_no = contact_no;
        this.email_id = email_id;
    }

    public String toString()
    {
        return "\nEmployee Details :" + "\nID: " + this.id + "\nName: " + this.name + "\nAge" + this.age +
                "\nCompany Name" + this.company_name + "\nDesignation"+ this.designation + "\nSalary: " +
                this.salary + "\nContact No: " + this.contact_no + "\nEmail-id: " + this.email_id;
    }

}

public class EmpData {
    static void display(ArrayList<Employee> al) {
        System.out.println("\n--------------Employee List---------------\n");
        System.out.println(String.format("%-10s%-15s%-10s%-20s%-20s%-10s%-20s%-10s", "ID", "Name", "Age",
                "Company Name", "Designation", "salary", "contact-no", "Email-Id"));
        for (Employee e : al) {
            System.out.println(String.format("%-5s%-20s%-10s%-20s%-20s%-10s%-15s%-10s", e.id, e.name, e.age,
                    e.company_name, e.designation, e.salary, e.contact_no, e.email_id));
        }
    }

    @SuppressWarnings("unchecked")
    public static void emp() {
        int id;
        String name;
        int age;
        String company_name;
        String designation;
        float salary;
        long contact_no;
        String email_id;

        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> al = new ArrayList<Employee>();

        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {

            f = new File("C:\\Users\\darshb\\Desktop\\MainassignmentJava\\src\\EmployeeData.txt");
            if (f.exists()) {
                fis = new FileInputStream(f);
                ois = new ObjectInputStream(fis);
                al = (ArrayList<Employee>) ois.readObject();
            }

        } catch (Exception exp) {
            System.out.println(exp);
        }
        do {

            System.out.println("****** Welcome to User Database ******");
            System.out.println("1. Add User Data");
            System.out.println("2. Update User Data");
            System.out.println("3. Delete User Data");
            System.out.println("4. Display Employee Data");
            System.out.println("5. Save and Exit");

            System.out.println("Select an option: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.println("\nEnter the following details to ADD list:\n");
                    System.out.println("Enter ID :");
                    id = sc.nextInt();

                    System.out.println("Enter Name :");
                    name = sc.nextLine();
                    name += sc.nextLine();

                    System.out.println("Enter age");
                    age = sc.nextInt();
                    if (age < 18 || age > 90) {
                        System.out.println("Invalid age");
                        break;
                    }

                    System.out.println("Enter Company Name");
                    company_name = sc.nextLine();
                    company_name += sc.nextLine();

                    System.out.println("Enter Designation");
                    designation = sc.nextLine();

                    System.out.println("Enter Salary :");
                    salary = sc.nextFloat();
                    if (salary <= 0.0) {
                        System.out.println("Invalid salary value");
                        break;
                    }

                    System.out.println("Enter Contact No :");
                    contact_no = sc.nextLong();
                    int length = String.valueOf(Long.toString(contact_no)).length();
                    if (length != 10) {
                        System.out.println("Invalid Phone Number");
                        break;
                    }

                    System.out.println("Enter Email-ID :");
                    email_id = sc.next();

                    al.add(new Employee(id, name, salary, contact_no, email_id, age, company_name, designation));
                    display(al);
                    break;

                case 2:
                    System.out.println("\nEnter the Employee ID to EDIT the details");
                    id = sc.nextInt();
                    int j = 0;
                    for (Employee e : al) {
                        if (id == e.id) {
                            j++;
                            do {
                                int ch1 = 0;
                                System.out.println("\nEDIT Employee Details :\n" +

                                        "1). Name\n" +
                                        "2). Salary\n" +
                                        "3). Age\n" +
                                        "4). Company name\n" +
                                        "5). Designation\n" +
                                        "6). Contact No.\n" +
                                        "7). Email-ID\n" +
                                        "8). GO BACK\n");
                                System.out.println("Enter your choice : ");
                                ch1 = sc.nextInt();
                                switch (ch1) {
                                    case 1:
                                        System.out.println("Enter new Employee Name:");
                                        e.name = sc.next();
                                        System.out.println(e + "\n");
                                        break;

                                    case 2:
                                        System.out.println("Enter new Employee Salary:");
                                        e.salary = sc.nextFloat();
                                        System.out.println(e + "\n");
                                        break;

                                    case 3:
                                        System.out.println("Enter new Employee Age:");
                                        e.age = sc.nextInt();
                                        System.out.println(e + "\n");
                                        break;

                                    case 4:
                                        System.out.println("Enter new Company Name:");
                                        e.company_name = sc.next();
                                        System.out.println(e + "\n");
                                        break;

                                    case 5:
                                        System.out.println("Enter new Employee Designation:");
                                        e.designation = sc.next();
                                        System.out.println(e + "\n");
                                        break;

                                    case 6:
                                        System.out.println("Enter new Employee Contact No. :");
                                        e.contact_no = sc.nextLong();
                                        System.out.println(e + "\n");
                                        break;

                                    case 7:
                                        System.out.println("Enter new Employee Email-ID :");
                                        e.email_id = sc.next();
                                        System.out.println(e + "\n");
                                        break;

                                    case 8:
                                        j = j + 1;
                                        break;

                                    default:
                                        System.out.println("\nEnter a correct choice from the List :");
                                        break;

                                }
                            }
                            while (j == 1);
                        }
                    }
                    if (j == 0) {
                        System.out.println("\nEmployee Details are not available, Please enter a valid ID!!");
                    }

                    break;

                case 3:
                    System.out.println("\nEnter Employee ID to DELETE from the Databse :");
                    id = sc.nextInt();
                    int k = 0;
                    try {
                        for (Employee e : al) {
                            if (id == e.id) {
                                al.remove(e);
                                display(al);
                                k++;
                            }
                        }
                        if (k == 0) {
                            System.out.println("\nEmployee Details are not available, Please enter a valid ID!!");
                        }
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                    break;

                case 4:
                    try {
                        al = (ArrayList<Employee>) ois.readObject();

                    } catch (ClassNotFoundException e2) {

                        System.out.println(e2);
                    } catch (Exception e2) {

                        System.out.println(e2);
                    }
                    display(al);
                    break;

                case 5:
                    try {
                        fos = new FileOutputStream(f);
                        oos = new ObjectOutputStream(fos);
                        oos.writeObject(al);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    } finally {
                        try {
                            fis.close();
                            ois.close();
                            fos.close();
                            oos.close();
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }

                    }
                    System.out.println("\nYou have chosen EXIT !! Saving Files and closing the tool.");

                    return;

                default:
                    System.out.println("\nEnter a correct choice from the List :");
                    break;

            }
        }
        while (true);
    }
}