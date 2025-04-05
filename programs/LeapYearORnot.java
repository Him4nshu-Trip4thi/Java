import java.util.Scanner;

public class LeapYearORnot 
{
    public static void main (String Args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Year in YYYY format : ");
        int year=sc.nextInt();
        sc.close();

        boolean x=year%4==0;
        boolean y=year%100!=0;
        boolean z=(year%100==0) && (year%400==0);

        if(x && (y||z))
        {
            System.out.println("ENTERED YEAR IS A LEAP YEAR");
        }
        else{
            System.out.println("ENTERED YEAR IS A NOT LEAP YEAR");

        }
    }
}
