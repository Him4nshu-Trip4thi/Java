import java.util.Scanner;

public class SeachInASortedMatrix 
{
    public static boolean StaircaseSearch(int matrix[][],int key)
    {
        int row=0,col=matrix[row].length-1;
        while(row<matrix.length && col>=0)
        {
            if(matrix[row][col]==key)
            {
                System.out.println("The entered key is present in the matrix at index : (" + row + " , " + col + ")");
                return true;
            }
            else if(key<matrix[row][col])
            {
                col--;
            }
            else
            {
                row++;
            }
        }
        System.out.println("The entered key is not present in the matrix. ERROR404");
        return false;
    }
    public static void main(String Args[])
    {
        int matrix[][]={{10,20,30,40},{12,25,35,45},{27,29,37,48},{32,33,39,50}};
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the key to be searched : " );
        int key=sc.nextInt();
        sc.close();

        StaircaseSearch(matrix, key);
    }
    
}
