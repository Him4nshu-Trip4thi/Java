import java.util.Scanner;

public class FindPermutation{
    static int count = 0;
    public static void findPermutations(String str, String ans){
        //base case
        if(str.length() == 0){
            count++;
            System.out.println(count + ": " + ans);  // Printing permutation with its count
            return;
        }

        //recursion
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i + 1, str.length());
            findPermutations(newStr, ans + ch);
        }
    }

    public static void main (String[] Args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String: ");
        String str = sc.nextLine();
        sc.close();

        findPermutations(str, "");
    }
}
