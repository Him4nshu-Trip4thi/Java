//          <- BINARY STRING PROBLEM ->
//Print all binary strings of N size without the consecutive ones.

import java.util.Scanner;

public class BinaryStringProblem 
{
    public static void BinaryString(int n , int LastPlace , String str)
    {
        //base case
        if(n==0)
        {
            System.out.println(str);
            return;
        }
        //Operations
        BinaryString(n-1,0, str+"0");
        if(LastPlace==0)
        {
            BinaryString(n-1,1, str+"1");
        }
        
    }

    public static void main(String Args[])
    {
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter size of string : ");
        int N=sc.nextInt();
        sc.close();

        BinaryString(N,0,"");
    }
}
