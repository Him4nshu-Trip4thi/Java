public class ReverseArray
{
    public static int[] ReverseNspace(int arr[])
    {
        int arr1[]=new int[arr.length];
        int j=0;
        for(int i=arr.length-1;i>=0;i--)
        {
            arr1[j]=arr[i];
            j++;
        }
        return arr1;
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
        int rev[]=ReverseNspace(series);
        System.out.println("Reversed Array : ");
        for(int i=0;i<series.length;i++)
        {
            System.out.print(rev[i]+ " ");
        }
    }
    
}
