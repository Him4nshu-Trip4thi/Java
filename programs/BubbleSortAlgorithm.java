import java.util.Scanner;
public class BubbleSortAlgorithm
{
    public static void BubbleSort(int arr[])
    {
        int n=arr.length;
        for(int i=0;i<n-1;i++)
        {
            int swap=0; //optimisation for sorted array
            for(int j=0;j<n-1-i;j++)
            {
                if(arr[j]>arr[j+1])
                {
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    swap++;
                }
            }

            if(swap==0) 
            {
                break;
            }
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

        BubbleSort(arr);

        System.out.print("Sorted Array : ");
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
}