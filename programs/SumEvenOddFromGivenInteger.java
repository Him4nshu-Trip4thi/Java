import java.util.Scanner;

public class SumEvenOddFromGivenInteger 
{
    public static void main (String Args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter No. : ");
        int num=sc.nextInt();
        sc.close();
        int evenSum=0;
        int oddSum=0;
        while (num>0)
        {
            int r=num%10;
            if(r%2==0)
            {
                evenSum+=r;
            }
            else{
                oddSum+=r;
            }
            num/=10;
        }
        System.out.println("Even Sum : "+ evenSum);
        System.out.println("Odd Sum : " + oddSum);
    }
    
}
