import java.util.Scanner;

public class SumOfElementOfParticularRow 
{
    public static void SumOfRow(int matrix[][],int row)
    {
        int sum=0;
        for(int col=0;col<matrix[row].length;col++)
        {
            sum+=matrix[row][col];
        }
        System.out.println("Sum of "+row+" row is " + sum +".");
    }
    public static void main (String Args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter row number to sum : ");
        int row=sc.nextInt();
        sc.close();

        int matrix[][]={ {1,4,9},{11,4,3},{2,2,3} };

        SumOfRow(matrix,row-1);
    }
    
}
