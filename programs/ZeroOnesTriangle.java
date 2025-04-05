import java.util.Scanner;

public class ZeroOnesTriangle {
    public static void ZeroOne(int n)
    {
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=i;j++)
            {
                if((i+j)%2==0)
                {
                    System.out.print("1 ");
                }
                else
                {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }
    public static void main (String Args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter NO. : ");
        int num=sc.nextInt();
        sc.close();

        ZeroOne(num);
    }
    
}
