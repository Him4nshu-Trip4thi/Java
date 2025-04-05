import java.util.Scanner;

public class LinearSearch
{
    public static int L_Search(int arr[],int key)
    {
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==key)
            {
                return i;
            }
        }
        return -1;
    }
    public static void main (String Args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter key : ");
        int key=sc.nextInt();
        sc.close();

        int series[]={9,7,8,5,6,4,2,0,3,1};
        int Index=L_Search(series,key);
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