import java.util.Scanner;

public class HollowRhombus 
{
    public static void HollowRhombusPattern(int n)
    {
        for(int i=1;i<=n;i++)
        {
            for(int sp=1;sp<n-i+1;sp++)
            {
                System.out.print(" ");
            }
            if((i==1)||(i==n))
            {
                for(int j=1;j<=n;j++)
                {
                    System.out.print("* ");
                }
            }
            else
            {
                System.out.print("* ");
                for(int j=2;j<=n-1;j++)
                {
                    System.out.print("  ");
                }
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void main (String Args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter No. : ");
        int num=sc.nextInt();
        sc.close();

        HollowRhombusPattern(num);
    }
    
}
