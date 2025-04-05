public class TransposeOfAMatrix 
{
    public static void Transpose(int matrix[][])
    {
        System.out.println("The transpose of the given matrix is : ");
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                System.out.print(matrix[j][i] + " ");
            }
            System.out.println();
        }
    }
    public static void main (String Args[])
    {
        int matrix[][]={{1,5,4},{1,4,8},{5,8,4}};
        System.out.println("The original matrix is : ");
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        Transpose(matrix);
    }
    
}
