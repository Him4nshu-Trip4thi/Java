import java.util.*;
public class CostBilling 
{
    public static void main (String Args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Cost of Pencil : ");
        float pencil=sc.nextFloat();
        System.out.println("Enter Cost of Pen : ");
        float pen=sc.nextFloat();
        System.out.println("Enter Cost of Eraser : ");
        float eraser=sc.nextFloat();
        sc.close();

        double TotalCost=pen+pencil+eraser+(0.18*pen+0.18*pencil+0.18*eraser);
        System.out.println("The total Cost is : "+TotalCost);


    }
}
