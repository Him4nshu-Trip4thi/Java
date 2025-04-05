// Question 2 : You are given a number (eg -  2019),
// convert it into a String of english like“two zero one nine”.
//  Use a recursive function to solve this problem.
//NOTE-The digits of the number will only be in the range 0-9 and the last digit of a number can’t be 0.
//Sample Input: 1947
//Sample Output: “one nine four seven”

import java.util.Scanner;

public class ConvNoToStr 
{
    static String digit[]={"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
    public static void Converter(int n)
    {
        if(n==0)
        {
            return;
        }
        int LastDigit=n%10;
        Converter(n/10);

        System.out.print(digit[LastDigit]+" ");
    }
    public static void main(String Args[])
    {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter Number : ");
        int N=sc.nextInt();
        sc.close();
        
        Converter(N);
    }
    
}
