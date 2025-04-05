import java.util.Scanner;

public class HollowRectangle
{
    public static void main (String Args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the details below : ");
        System.out.print("Enter Length : ");
        int l=sc.nextInt();
        System.out.print("Enter Bredth : ");
        int b=sc.nextInt();
        sc.close();

        for(int i=1;i<=l;i++)
        {
            if((i==1)||(i==l))
            {
                for(int j=1;j<=b;j++)
                {
                    System.out.print("* ");
                }
            }
            else
            {
                System.out.print("* ");
                for(int j=2;j<=b-1;j++)
                {
                    System.out.print("  ");
                }
                System.out.print("*");
            }
            System.out.println();
        }

    }
}