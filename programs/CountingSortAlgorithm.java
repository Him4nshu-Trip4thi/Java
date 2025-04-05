public class CountingSortAlgorithm 
{
    public static void CountingSort(int arr[])
    {
        //finding the largest
        int largest=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            largest=Math.max(largest,arr[i]);
        }

        //finding frequency
        int count[]=new int[largest+1];
        for(int i=0;i<arr.length;i++)
        {
            count[arr[i]]++;
        }

        //sorting
        int j=0;
        for(int i=0;i<count.length;i++)
        // for(int i=count.length-1;i>=0;i--)
        {
            while(count[i]>0)
            {
                arr[j]=i;
                j++;
                count[i]--;
            }
        }

    }
    public static void main (String Args[])
    {
        int arr[]={7,4,3,1,9,2,1,4,7,5,6,2,1,5,4,5,6,3,1};

        System.out.print("Original Array : ");
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        
        CountingSort(arr);

        System.out.print("Sorted Array : ");
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
    
}
