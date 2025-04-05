import java.util.Scanner;

public class DiamondPattern
{
    public static void Diamond(int n)
    {
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n-i;j++)
            {
                System.out.print("  ");
            }
            for(int j=1;j<=2*i-1;j++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }

        //mirror pattern
        for(int i=n;i>=1;i--)
        {
            for(int j=1;j<=n-i;j++)
            {
                System.out.print("  ");
            }
            for(int j=1;j<=2*i-1;j++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void main (String Args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. : ");
        int num=sc.nextInt();
        sc.close();

        Diamond(num);
    }
}