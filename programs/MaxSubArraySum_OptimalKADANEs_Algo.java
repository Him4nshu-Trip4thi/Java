public class MaxSubArraySum_OptimalKADANEs_Algo 
{
    public static int MaxSubArraySum(int arr[])
    {
        int negCount=0;
        int CurrSum=0;
        int MaxSum=Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]<0)
            {
                negCount++;
            }
        }

        if(negCount==arr.length)
        {
            for(int i=0;i<arr.length;i++)
            {
                MaxSum=Math.max(MaxSum,arr[i]);
            }
        }
        else
        {

        for(int i=0;i<arr.length;i++)
        {
            CurrSum+=arr[i];
            if(CurrSum<0)
            {
                CurrSum=0;
            }
            MaxSum=Math.max(MaxSum,CurrSum);
        }
        }
        

        return MaxSum;
        
    }
    public static void main (String Args[])
    {
        int series[]={1,3,5,7,9,0,2,4,6,8};
        System.out.println("The Maximum Subarray Sum is : "+MaxSubArraySum(series));
    }
    
}
