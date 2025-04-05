import java.util.Scanner;

public class isPalindrome 
{
    public static void checkPalindrome(int n)
    {
        int m=n;
        int rev=0;
        while(m>0)
        {
            int r=m%10;
            rev=rev*10+r;
            m/=10;
        }
        if(n==rev)
        {
            System.out.println("Palindrome Number");
        }
        else{
            System.out.println("Not a Palindrome Number");
        }
    }
    public static void main (String Args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter No. : ");
        int num=sc.nextInt();
        sc.close();

        checkPalindrome(num);
    }
    
}
