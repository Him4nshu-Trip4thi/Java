import java.util.Scanner;

public class AverageFunc 
{
    public static int Average(int a , int b , int c)
    {
        return (a+b+c)/3;
    }
    public static void main(String Args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter No. : ");
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        sc.close();

        System.out.println("The Average of provided three numbers are : " + Average(a,b,c));
    }
    
}
