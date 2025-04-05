public class SubArrays
{
    public static void printAllSubArray(int arr[])
    {
        int n=arr.length;
        for(int i=0;i<n;i++)
        {
            int start=i;
            for(int j=i;j<n;j++)
            {
                int end=j;
                for(int k=start;k<=end;k++)
                {
                    System.out.print(arr[k] + " ");
                }
                if(j!=n-1)
                {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
    public static void main (String Args[])
    {
        int series[]={1,3,5,7,9,0,2,4,6,8};
        printAllSubArray(series);
    }
}