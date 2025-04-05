import java.util.Scanner;

public class InsertionSortAlgorithm
{
    public static void InsertionSort(int arr[])
    {
        for(int i=1;i<arr.length;i++)
        {
            int curr=arr[i];
            int prev=i-1;
            while(prev>=0 && arr[prev]>curr)
            {
                arr[prev+1]=arr[prev];
                prev--;
            }
            //insertion
            arr[prev+1]=curr;
        }
    }
    public static void main (String Args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter length of Array : ");
        int n=sc.nextInt();
        

        System.out.println("Enter Elements : ");
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        sc.close();
        // int arr[]={8,6,7,1,4,2,5,3,6,7,0,2,1,3,9,8,7};

        InsertionSort(arr);

        System.out.print("Sorted Array : ");
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
    
}
