public class overload {
    void area(float x)
    {
        System.out.println("area of the square is "+ Math.pow(x,2)+"sq units");
    }
    void area(float x, float y)
    {
        System.out.println("the area of the rectangle is"+x*y+"sq units");
    }
    void area(double x)
    {
        double z =3.14*x*x;
        System.out.println("the area of the circle is"+z+"sq units");
    }
    void area(float a, float b, float c)
    {
        double temp = (a + b + c);
        double s= temp/2;
        double tri = Math.sqrt(s*(s-a)*(s-b)*(s-c));
        System.out.println( " Area of triangle with lenght of sides  "+a+"," +b+ " and " +c+" is : "+ tri);
    }
}
class Overloaddemo

{
    public static void main(String args[])
    {
        overload po=  new overload();
        po.area(4);
        po.area(10,12);
        po.area(2.5);
        po.area(5,7,9);
    }
}

