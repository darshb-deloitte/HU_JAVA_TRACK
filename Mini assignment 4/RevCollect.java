import java.util.*;

public class RevCollect
{
    public static void main(String[] args) {

        ArrayList<String> arrylist = new ArrayList<String>();

        arrylist.add("Hashedin");
        arrylist.add("by");
        arrylist.add("Deloitte");
        arrylist.add("2022");
        System.out.println(" List:"+arrylist);
        Collections.reverse(arrylist);
        System.out.println("ReverseList:"+arrylist);
    }
}
