import java.util.Scanner;

public class InvertedNumhalfPyramid 
{
    public static void main (String Args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter No. : ");
        int num=sc.nextInt();
        sc.close();

        for(int i=1;i<=num;i++)
        {
            for(int j=1;j<=num-i+1;j++)
            {
                System.out.print(j);
            }
            System.out.println();
        }
    }
    
}
