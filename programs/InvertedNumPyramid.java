import java.util.Scanner;

public class InvertedNumPyramid 
{
    public static void main (String Args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter No. : ");
        int num=sc.nextInt();
        sc.close();
        int counter=1;

        for(int i=1;i<=num;i++)
        {
            for(int j=1;j<=num-i+1;j++)
            {
                System.out.print(counter);
                counter++;
            }
            System.out.println();
        }
    }
    
}
