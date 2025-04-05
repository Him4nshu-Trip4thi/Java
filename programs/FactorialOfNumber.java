import java.util.*;

public class FactorialOfNumber
{
    public static void main (String Args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Number : ");
        long num=sc.nextLong();    
        sc.close();
        long fact=1;
        for(long i=1;i<=num;i++)
        {
            fact*=i;
        }
        System.out.println("Factorial is : "+fact);
    }
}