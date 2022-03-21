import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;


class Employee implements Serializable{

    int id;
    String name;
    float salary;
    long contact_no;
    String email_id;

    public Employee(int id, String name, float salary, long contact_no, String email_id)
    {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.contact_no = contact_no;
        this.email_id = email_id;
    }

    public String toString()
    {
        return "\nEmployee Details :" + "\nID: " + this.id + "\nName: " + this.name + "\nSalary: " +
                this.salary + "\nContact No: " + this.contact_no + "\nEmail-id: " + this.email_id;
    }

}

public class EmpData
{
    static void display(ArrayList<Employee> al)
    {
        System.out.println("\n--------------Employee List---------------\n");
        System.out.println(String.format("%-10s%-15s%-10s%-20s%-10s", "ID","Name","salary","contact-no","Email-Id"));
        for(Employee e : al)
        {
            System.out.println(String.format("%-5s%-20s%-10s%-15s%-10s",e.id,e.name,e.salary,e.contact_no,e.email_id));
        }
    }


    public static void emp()
    {
        int id;
        String name;
        float salary;
        long contact_no;
        String email_id;

        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> al = new ArrayList<Employee>();

        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos =null;
        try{

            f = new File("C:\\Users\\darshb\\Desktop\\HU_JAVA_TRACK\\Main_assignment\\Main\\src\\EmployeeDataList2");
            if(f.exists())
            {
                fis = new FileInputStream(f);
                ois = new ObjectInputStream(fis);
                al = (ArrayList<Employee>)ois.readObject();
            }

        }
        catch(Exception exp){
            System.out.println(exp);
        }
        do
        {

            System.out.println("****** Welcome to User Database ******");
            System.out.println("1. Add User Data");
            System.out.println("2. Update User Data");
            System.out.println("3. Delete User Data");
            System.out.println("4.Display Employee Data");
            System.out.println("5. Exit");

            System.out.println("Select an option: ");
            int ch = sc.nextInt();

            switch(ch)
            {
                case 1:System.out.println("\nEnter the following details to ADD list:\n");
                    System.out.println("Enter ID :");
                    id = sc.nextInt();
                    System.out.println("Enter Name :");
                    name = sc.next();
                    System.out.println("Enter Salary :");
                    salary = sc.nextFloat();
                    System.out.println("Enter Contact No :");
                    contact_no = sc.nextLong();
                    System.out.println("Enter Email-ID :");
                    email_id = sc.next();
                    al.add(new Employee(id, name, salary, contact_no, email_id));
                    display(al);
                    break;



                case 2: System.out.println("\nEnter the Employee ID to EDIT the details");
                    id = sc.nextInt();
                    int j=0;
                    for(Employee e: al)
                    {
                        if(id == e.id)
                        {
                            j++;
                            do{
                                int ch1 =0;
                                System.out.println("\nEDIT Employee Details :\n" +

                                        "1). Name\n" +
                                        "2). Salary\n" +
                                        "3). Contact No.\n" +
                                        "4). Email-ID\n" +
                                        "5). GO BACK\n");
                                System.out.println("Enter your choice : ");
                                ch1 = sc.nextInt();
                                switch(ch1)
                                {
                                    case 1: System.out.println("Enter new Employee Name:");
                                        e.name = sc.next();
                                        System.out.println(e+"\n");
                                        break;

                                    case 2: System.out.println("Enter new Employee Salary:");
                                        e.salary =sc.nextFloat();
                                        System.out.println(e+"\n");
                                        break;

                                    case 3: System.out.println("Enter new Employee Contact No. :");
                                        e.contact_no =sc.nextLong();
                                        System.out.println(e+"\n");
                                        break;

                                    case 4: System.out.println("Enter new Employee Email-ID :");
                                        e.email_id =sc.next();
                                        System.out.println(e+"\n");
                                        break;

                                    case 5: j = j+1;
                                        break;

                                    default : System.out.println("\nEnter a correct choice from the List :");
                                        break;

                                }
                            }
                            while(j==1);
                        }
                    }
                    if(j == 0)
                    {
                        System.out.println("\nEmployee Details are not available, Please enter a valid ID!!");
                    }

                    break;

                case 3: System.out.println("\nEnter Employee ID to DELETE from the Databse :");
                    id = sc.nextInt();
                    int k=0;
                    try{
                        for(Employee e: al)
                        {
                            if(id == e.id)
                            {
                                al.remove(e);
                                display(al);
                                k++;
                            }
                        }
                        if(k == 0)
                        {
                            System.out.println("\nEmployee Details are not available, Please enter a valid ID!!");
                        }
                    }
                    catch(Exception ex){
                        System.out.println(ex);
                    }
                    break;

                case 4: try {
                    al = (ArrayList<Employee>)ois.readObject();

                } catch (ClassNotFoundException e2) {

                    System.out.println(e2);
                } catch (Exception e2) {

                    System.out.println(e2);
                }
                    display(al);
                    break;

                case 5: try {
                    fos = new FileOutputStream(f);
                    oos = new ObjectOutputStream(fos);
                    oos.writeObject(al);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                catch(Exception e2){
                    e2.printStackTrace();
                }
                finally{
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
                    sc.close();
                    System.exit(0);
                    break;

                default : System.out.println("\nEnter a correct choice from the List :");
                    break;

            }
        }
        while(true);
    }

}