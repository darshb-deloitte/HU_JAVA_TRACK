import java.util.Scanner;
public class Pattern
{
    public static void main(String[] args)
    {
        int i, j, k, row;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of row you want to print: ");
        row = sc.nextInt();
        for (i= 1; i<= row ; i++)
        {
            for (j=i; j <row ;j++)
            {
                System.out.print(" ");
            }
            for (k=1; k<=i;k++)
            {
                System.out.print("*");
            }
            System.out.println("");
        }
        for (i=row; i>=1; i--)
        {
            for(j=i; j<=row;j++)
            {
                System.out.print(" ");
            }
            for(k=1; k<i ;k++)
            {
                System.out.print("*");
            }
            System.out.println("");
        }
        sc.close();
    }
}