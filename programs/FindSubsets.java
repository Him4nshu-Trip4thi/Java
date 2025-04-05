import java.util.Scanner;

public class FindSubsets{
    public static void genSubsets(String str, String ans, int i){
        //base case
        if(i==str.length()){
            System.out.println(ans);
            return;
        }


        //recursion
        genSubsets(str, ans+str.charAt(i), i+1); // if YES
        genSubsets(str, ans, i+1); //if NO
        
    }
    public static void main (String[] Args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter String : ");
        String str=sc.nextLine();
        sc.close();

        genSubsets(str,"",0);
    }
}