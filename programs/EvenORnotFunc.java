import java.util.Scanner;

public class EvenORnotFunc 
{
    public static boolean EvenORnot(int n)
    {
        return (n%2==0);
    }
    public static void main (String Args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter No. : ");
        int num=sc.nextInt();
        sc.close();
        System.out.println(EvenORnot(num));

    }
    
}
