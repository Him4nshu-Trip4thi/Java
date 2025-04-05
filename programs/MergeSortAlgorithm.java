public class MergeSortAlgorithm 
{
    public static void MergeSort(int arr[],int si,int ei)
    {
        if(si>=ei)
        {
            return;
        }

        int mid=si+(ei-si)/2;

        MergeSort(arr, si, mid);
        MergeSort(arr, mid+1 ,ei);
        Merge(arr,si,mid,ei);
    }

    public static void Merge(int arr[],int si,int mid,int ei)
    {
        int temp[]=new int[ei-si+1];
        int i=si; //iterator for left arr
        int j=mid+1; //iterator for right arr
        int k=0; //iterator for temp arr

        while(i<=mid && j<=ei)
        {
            if(arr[i]<arr[j])
            {
                temp[k]=arr[i];
                i++;
            }
            else
            {
                temp[k]=arr[j];
                j++;
            }

            k++;
        }

        while(i<=mid)
        {
            temp[k++]=arr[i++];
        }
        while(j<=ei)
        {
            temp[k++]=arr[j++];
        }

        for(k=0 , i=si ; k<temp.length; k++ , i++) 
        {
            arr[i]=temp[k];
        }
    }

    public static void main (String Args[])
    {
        int arr[]={6,3,9,5,2,8,-8,-9,-1};

        MergeSort(arr,0,arr.length-1);

        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
    
    
}
