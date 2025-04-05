import java.util.Scanner;

public class FrequencyOfGivenNumInMatrix
{
    public static void CountOfNum(int matrix[][], int num)
    {
        int count=0;
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[i].length;j++)
            {
                if(matrix[i][j]==num)
                {
                    count++;
                }
            }
        }
        System.out.println("The entered number " + num + " appeared "+ count +" times.");
    }
    public static void main (String Args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Number to count : ");
        int num=sc.nextInt();
        sc.close();

        int matrix[][]={{1,5,4},{1,4,8},{5,8,4}};

        CountOfNum(matrix,num);
    }
}