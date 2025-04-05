import java.util.Scanner;

public class InputToMatrix
{
    public static void main (String Args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter no. of Rows : ");
        int r=sc.nextInt();
        System.out.print("Enter no. of Columns : ");
        int c=sc.nextInt();
        sc.close();

        int matrix [][]=new int [r][c];

        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                System.out.print("Enter elements for ("+i+","+j+") : ");
                matrix[i][j]=sc.nextInt();
            }
        }

        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

    }
}