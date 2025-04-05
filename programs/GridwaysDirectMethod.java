import java.util.Scanner;

public class GridwaysDirectMethod {
    public static long factorial(int n){
        long res=1;
        for(int i=1;i<=n;i++){
            res=res*i;
        }
        return res;
    }
    public static long gridWays(int n, int m){
        long num=factorial(n-1+m-1);
        long deno=factorial(n-1)*factorial(m-1);
        long ways=num/deno;
        return ways;

    }
    public static void main (String Args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter no. of rows: ");
        int row=sc.nextInt();
        System.out.print("Enter no. of columns: ");
        int col=sc.nextInt();
        sc.close();
        long tWays= gridWays(row,col);
        System.out.println("Total no. of ways to reach from SRC to DST with only down and right are: "+tWays);
    }
    
}
