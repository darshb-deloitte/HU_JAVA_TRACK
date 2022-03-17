import java.util.*;

class Anagram {
    public static void main(String[] args) {

        String str = "Silent".toLowerCase();
        String str1 = "Listen".toLowerCase();

        String[] strSplit = str.split("");
        String[] strSplit1 = str1.split("");

        ArrayList<String> strList = new ArrayList<String>(Arrays.asList(strSplit));
        ArrayList<String> strList1 = new ArrayList<String>(Arrays.asList(strSplit1));
        Collections.sort(strList);
        Collections.sort(strList1);



        boolean word = strList.equals(strList1);

        if (word){
            System.out.println("Its an Anagram");
        }
        else{
            System.out.println("Its not  an Anagram");
        }
    }
}
