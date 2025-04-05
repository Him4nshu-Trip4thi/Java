public class ReverseArrayOptimized
{
    public static int[] Reverse1space(int arr[])
    {
        int n=arr.length;
        int i=0;
        while(i<n)
        {
            int temp=arr[i];
            arr[i]=arr[n-1];
            arr[n-1]=temp;

            i++;n--;
        }
        return arr;
    }
    public static void main(String Args[])
    {
        int series[]={0,1,2,3,6,5,4,7,8,9};
        System.out.println("Original Array : ");
        for(int i=0;i<series.length;i++)
        {
            System.out.print(series[i]+" ");
        }
        System.out.println();
        int rev[]=Reverse1space(series);
        System.out.println("Reversed Array : ");
        for(int i=0;i<series.length;i++)
        {
            System.out.print(rev[i]+ " ");
        }
    }
    
}
