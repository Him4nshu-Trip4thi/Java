import java.util.*;
public class NthTable
{
    public static void main (String Args[])
    {
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter No. : ");
        int num=sc.nextInt();
        sc.close();

        for(int i=1;i<=10;i++)
        {
            int product=num*i;
            System.out.println(num + " " + "x" + " " + i + " " + "=" + " " +product);
        }
    }
}