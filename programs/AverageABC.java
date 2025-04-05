import java.util.*;
public class AverageABC
{
    public static void main (String Args[])
    {
        Scanner sc=new Scanner(System.in);
        int A=sc.nextInt();
        float B=sc.nextFloat();
        int C=sc.nextInt();
        sc.close();
        float Average =(A+B+C)/3;
        System.out.println(Average);
    }
}