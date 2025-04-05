//               <-TILING PROBLEM->
//Given a 2xN board or floor and tiles of size 2x1.
//Count the total number of ways to tile the given board or floor using the 2x1 tiles.
//It can be either hotizontal or vertical.

//for example : TEST CASES
// 1. n=0  ans=1  - No work done is also a work done
// 2. n=1  ans=1  - Just the tile vertically
// 3. n=2  ans=2  - Either vertical or horizontal
//Similarly,
// n=3 -> ans=3
// n=4 -> ans=5
// n=5 -> ans=8
// n=6 -> ans=13

import java.util.Scanner;

public class TilingProblem 
{
    public static int tiling(int N)
    {
        //base case
        if(N==0||N==1)
        {
            return 1;
        }

        //Recursive Operation
        int vertical=tiling(N-1);
        int horizontal=tiling(N-2);

        int TotalNumberOfWays=vertical+horizontal;
        return TotalNumberOfWays;
    }
    public static void main (String Args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the dimension of 2xN , where N = ?  : ");
        int n=sc.nextInt();
        sc.close();

        System.out.println("Total number of ways are : "+tiling(n));
    }
    
}
