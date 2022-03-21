class ExampleException {
    public static void main (String args[])
    {
        try
        {
            int num1=30 , num2=0;
            int output=num1/num2;
            System.out.println(output);
        }
        catch(ArithmeticException e)
        {
            System.out.println("You should not divide number by Zero");
        }
        finally{
            System.out.println("Thank You");
        }
    }
}
