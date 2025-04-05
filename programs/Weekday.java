import java.util.*;
public class Weekday
{
    public static void main (String Args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Weekday Number (1-7) : ");
        int num=sc.nextInt();
        sc.close();

        switch(num)
        {
            case 1: System.out.println("SUNDAY ");break;
            case 2: System.out.println("MONDAY ");break;
            case 3: System.out.println("TUESDAY ");break;
            case 4: System.out.println("WEDNESDAY ");break;
            case 5: System.out.println("THURSDAY ");break;
            case 6: System.out.println("FRIDAY ");break;
            case 7: System.out.println("SATURDAY ");break;
            default:System.out.println("INVALID INPUT");
        }
    }
}