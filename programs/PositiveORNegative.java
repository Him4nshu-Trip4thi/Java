import java.util.Scanner;

public class PositiveORNegative 
{
    public static void main (String Args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Number : ");
        int number=sc.nextInt();
        sc.close();

        if(number>=0)
        {
            System.out.println("Number is POSITIVE ");
        }
        else
        {
            System.out.println("Number is NEGATIVE ");
        }

    }
    
}
