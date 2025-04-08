import java.util.*;

public class ValidParenthesis {
    public static boolean isValidParenthesis(String str) {
        if(str.length()%2!=0) return false;
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            } 
            else {
                if (s.isEmpty()) return false;
                char top = s.peek();
                if ((ch == ')' && top == '(') || (ch == '}' && top == '{') || (ch == ']' && top == '[')) {
                    s.pop();
                } 
                else {
                    return false;
                }
            }
        }
        return s.isEmpty();
    }

    public static void main(String args[]) {
        String s = "((){}[])";
        System.out.println(isValidParenthesis(s)); // true
    }
}
