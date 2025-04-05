import java.util.*;
public class SwappingVariable
{
    public static void main (String Args[])
    {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        sc.close();
        int c=a;
        a=b;
        b=c;
        System.out.println(a +" "+ b);
    }
}