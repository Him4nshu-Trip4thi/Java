// import java.util.Scanner;

public class RecursionBasic
{
    //x^n x to the power n OPTIMIZED[O(logN)]
    public static long XtoThePowerNOptimized(int x , int n)
    {
        if(n==0)
        {
            return 1;
        }
        long halfPower=XtoThePowerNOptimized(x,n/2);
        long halfPowerSq=halfPower * halfPower; 

        if(n%2!=0) //if odd (2^5) then 2 * 2^2 * 2^2 therefore multiplying again with the base
        {
            halfPowerSq=x*halfPowerSq;
        }
        return halfPowerSq;
    }

    //x^n x to the power n
    public static int XtoThePowerN(int x,int n)
    {
        if(n==0)
        {
            return 1;
        }
        
        return x*XtoThePowerN(x, n-1);
    }


    //LinearSearch(Last-Occurence)
    public static int LastOccurence(int arr[],int key,int i)
    {
        if(i==arr.length)
        {
            return -1;
        }
        int isFound=LastOccurence(arr, key, i+1);

        if(isFound==-1&&arr[i]==key)
        {
            return i;
        }
        return isFound;
    }



    //LinearSearch (First-Occurence)
    public static int FirstOccurence(int arr[],int key , int i)//i=Starting Point
    {
        if(i==arr.length-1)
        {
            return -1;
        }
        if(arr[i]==key)
        {
            return i;
        }
        return FirstOccurence(arr, key, i+1);
    }

    public static boolean recursivePrime(int n)
    {
        return true;//still figuring out...
    }

    //Array Is Sorted Or Not
    public static boolean isSorted(int arr[] , int i)  //int i=StartingPoint
    {
        if(i==arr.length-1)
        {
            return true;
        }

        if(arr[i]>arr[i+1])
        {
            return false;
        }
        return isSorted(arr, i+1);

    }

    //Nth Fibonacci number
    public static int recursiveFib(int n)
    {
        if(n==0||n==1)
        {
            return n;
        }
        int fib=recursiveFib(n-1)+recursiveFib(n-2);
        return fib;

    }

    //Sum of N numbers
    public static int recursiveSum(int n)
    {
        int sum=0;
        if(n==1)
        {
            return 1;
        }
        sum=n+recursiveSum(n-1);
        return sum;
    }

    //Factorial of N
    public static int recursiveFactorial(int n)
    {
        if(n==0)
        {
            return 1;
        }
        int fact=n*recursiveFactorial(n-1);
        return fact;
    }

    //Printing 1 to N in Decreasing Order
    public static void recursiveDec(int n)
    {
        if(n==1)
        {
            System.out.print(n+" ");
            return;
        }
        System.out.print(n+" ");
        recursiveDec(n-1);
    }

    //Printing 1 to N in Increasing Order
    public static void recursiveInc(int n)
    {
        if(n==1)
        {
            System.out.print(n +" ");
            return;
        }
        recursiveInc(n-1);
        System.out.print(n+" ");
    }

    //Driver's Code....
    public static void main (String Args[])
    {
        // Scanner sc=new Scanner(System.in);
        // System.out.print("ENTER NUMBER : ");
        // int n=sc.nextInt();
        // sc.close();

        int n=11;
        int arr[]={1,2,3,4,4,5};

        System.out.print("In Increasing Order : ");
        recursiveInc(n);
        System.out.println();
        System.out.print("In Decreasing Order : ");
        recursiveDec(n);
        System.out.println();
        System.out.println("Factorial of "+n+" : "+recursiveFactorial(n));
        System.out.println("Sum : "+recursiveSum(n));
        System.out.println("Nth Fibonacci Number : "+recursiveFib(n));

        if(isSorted(arr, 0))
        {
            System.out.println("The Array is SORTED !!");
        }
        else
        {
            System.out.println("The Array is UNSORTED !!");
        }

        int index1=FirstOccurence(arr,4, 0);
        if(index1>=0)
        {
            System.out.println("The element is present at index : "+index1);
        }
        else
        {
            System.out.println("INVALID KEY !!");
        }

        int index2=LastOccurence(arr,4, 0);
        if(index2>=0)
        {
            System.out.println("The element is present at index : "+index2);
        }
        else
        {
            System.out.println("INVALID KEY !!");
        }

        int base=2;
        int power=20;
        System.out.println("The result is : "+XtoThePowerN(base, power));
        System.out.println("The optimized result is : "+XtoThePowerNOptimized(base, power));

    }
}