public class MaxSubArraySum_BruteForce 
{
    public static int MaxSubArraySum(int arr[])
    {
        int max=Integer.MIN_VALUE;
        int currSum;
        int n=arr.length;
        for(int i=0;i<n;i++)
        {
            int start=i;
            for(int j=i;j<n;j++)
            {
                int end=j;
                currSum=0;
                for(int k=start;k<=end;k++)
                {
                    currSum+=arr[k];
                }
                System.out.print(currSum+" ");
                if(max<currSum)
                {
                    max=currSum;
                }
            }
        }
        System.out.println();
        return max;
    }
    public static void main (String Args[])
    {
        int series[]={1,3,5,7,9,0,2,4,6,8};
        System.out.println("The Maximum Subarray Sum is : "+MaxSubArraySum(series));
    }
}
