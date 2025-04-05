public class MaxSubArraySum_PrefixSum_BetterApproach
{
    public static int MaxSubArraySum(int arr[])
    {
        int max=Integer.MIN_VALUE;
        int CurrSum;
        int n=arr.length;

        int prefix[]=new int[n];
        prefix[0]=arr[0];
        for(int i=1;i<n;i++)
        {
            prefix[i]=prefix[i-1]+arr[i];
        }

        for(int i=0;i<n;i++)
        {
            int start=i;
            for(int j=i;j<n;j++)
            {
                int end=j;
                CurrSum=start==0?prefix[end]:prefix[end]-prefix[start-1];
                if(max<CurrSum)
                {
                    max=CurrSum;
                }
            }
        }
        return max;
    }
    public static void main (String Args[])
    {
        int series[]={1,3,5,7,9,0,2,4,6,8};
        System.out.println("The Maximum Subarray Sum is : "+MaxSubArraySum(series));
    }
}

