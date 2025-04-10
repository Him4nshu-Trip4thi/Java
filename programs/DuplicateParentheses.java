import java.util.*;
public class DuplicateParentheses{
    public static boolean duplicateParentheses(String str){
        Stack<Character> s=new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch!=')'){
                s.push(ch);
            }
            if(ch==')'){
                int count=0;
                if(s.peek()!='('){
                    count++;
                    s.pop();
                }
                else{
                    if(count<1){
                        return true;
                    }
                }
            }
        }

        return false;
    }
    public static void main (String args[]){
        String str="(((a+(b)))+(c+d))";
        String str2="((a+b)+(c+d))";
        if(duplicateParentheses(str)){
            System.out.println("There are Duplicate Parentheses in str");
        } 
        else{
            System.out.println("There are no Duplicate Parentheses in str");
        }
        if(duplicateParentheses(str2)){
            System.out.println("There are Duplicate Parentheses in str2");
        } 
        else{
            System.out.println("There are no Duplicate Parentheses in str2");
        }
    }
}