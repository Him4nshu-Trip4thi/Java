import java.util.Scanner;

public class BinarySearch 
{
    public static int B_Search(int arr[],int key)
    {
        int n=arr.length;
        int beg=0;
        int end=n;
        while(beg<=end)
        {
            int mid=(beg+end)/2;
            if(arr[mid]==key)
            {
                return mid;
            }
            else
            {
                if(arr[mid]<key)
                {
                    beg=mid+1;
                }
                else
                {
                    end=mid-1;
                }
            }
        }
        return -1;
    }
    public static void main(String Args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Pre-requisite : Array should be sorted.");
        System.out.print("Enter key : ");
        int key=sc.nextInt();
        sc.close();

        int series[]={0,2,4,6,8,10,12,14,16,18,20};
        int Index=B_Search(series,key);
        
        if(Index>=0)
        {
            System.out.println("The key is at Index : "+Index);
        }
        else
        {
            System.out.println("Invalid Key");
        }
    }
    
}
