import java.util.Scanner;

public class SelectionSortAlgorithm 
{
    public static void SelectionSort(int arr[])
    {
        int n=arr.length;
        for(int i=0;i<n-1;i++)
        {
            int Minpos=i;
            for(int j=i+1;j<n;j++)
            {
                if(arr[Minpos]>arr[j])
                {
                    Minpos=j;
                }
            }
            //swap
            int temp=arr[Minpos];
            arr[Minpos]=arr[i];
            arr[i]=temp;
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

        SelectionSort(arr);

        System.out.print("Sorted Array : ");
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
    
}
