import java.util.*;
public class FeverORnot 
{
    public static void main(String[]args)
    {
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter Temperature : ");
        double temp=sc.nextDouble();
        sc.close();

        if(temp>100)
        {
            System.out.println("YOU HAVE FEVER");
        }
        else{
            System.out.println("YOU DON'T HAVE FEVER");
        }

    }

    

}
