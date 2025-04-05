import java.util.Scanner;

public class Rhombus
{
    public static void FillRhombus(int n)
    {
        for(int i=1;i<=n;i++)
        {
            for(int sp=1;sp<=n-i;sp++)
            {   
                System.out.print("  ");
            }
            for(int j=1;j<=n;j++)
            {
                System.out.print("* ");
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

        FillRhombus(num);
    }
}