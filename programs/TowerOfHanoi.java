import java.util.Scanner;

public class TowerOfHanoi 
{
    public static void TOH(int n, String Source, String Helper, String Destination)
    {
        if(n==1)
        {
            System.out.println("Transfer Disk "+n+" from "+Source+" to "+Destination);
            return;
        }
        //tranfering top n-1 disk from "source" to "helper" using "destination" as "helper"
        TOH(n-1, Source, Destination, Helper);

        //transfered "source" to "destination"
        System.out.println("Transfer Disk "+n+" from "+Source+" to "+Helper);
        
        //transfering n-1 disk from "helper" to "destination" using "source" as "helper"
        TOH(n-1, Helper, Source, Destination);
    }
    public static void main(String Args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Number of DISKs : ");
        int n=sc.nextInt();
        sc.close();

        TOH(n,"A","B","C");
    }
}
