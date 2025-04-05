public class PairNonRecurring
{
    public static void pair(int arr[])
    {
        int n=arr.length;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                System.out.print("[ "+arr[i]+" , "+arr[j]+" ]");
            }
            System.out.println();
        }
    }
    public static void main(String Args[])
    {
        int series[]={2,4,6,8,10,12,14,16,18,20};
        
        pair(series);
    }
}