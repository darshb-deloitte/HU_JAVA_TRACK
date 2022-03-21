import java.io.*;
import java.util.*;


public class filehandling2 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new FileReader("src\\StudentData1.csv"));
            List<String> ls = new ArrayList<>();
            int i = 0;
            while (sc.hasNext()) {
                String[] str = sc.nextLine().split(",");
                if (i != 0) {
                    if (Integer.parseInt(str[4])>=1 && Integer.parseInt(str[4])<=5) {
                        ls.add(new String(str[0]+" "+ str[1]+" "+ str[2]+" "+ str[3]+" "+Integer.parseInt(str[4])));
                        System.out.println(str[0] + " " + str[1] + " " + str[2] + " " + str[3] + " " + str[4]);
                    }
                }
                i++;
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

    }
}
