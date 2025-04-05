// 678. Valid Parenthesis String

// Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.

// The following rules define a valid string:

// Any left parenthesis '(' must have a corresponding right parenthesis ')'.
// Any right parenthesis ')' must have a corresponding left parenthesis '('.
// Left parenthesis '(' must go before the corresponding right parenthesis ')'.
// '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
 

// Example 1:

// Input: s = "()"
// Output: true
// Example 2:

// Input: s = "(*)"
// Output: true
// Example 3:

// Input: s = "(*))"
// Output: true

public class ValidParenthesisString
{
    public static boolean checkValidString(String s) 
    {
        int leftp=0;
        int rightp=0;
        int star=0;

        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            {
                leftp++;
            }
            else if(s.charAt(i)==')')
            {
                if(leftp==0 && star==0)
                {
                    return false;
                }
                rightp++;
            }
            else
            {
                star++;
            }
        }
        
        System.out.println(leftp);
        System.out.println(rightp);
        System.out.println(star);

        if(leftp==rightp)
        {
            return true;
        }

        for(int i=1;i<=star;i++)
        {
            if((leftp==rightp-i) || (leftp-i==rightp))
            {
                return true;
            }
        }
        return false;
        
    }
    public static void main (String Args[])
    {
        String s="((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()";
        System.out.println(checkValidString(s));
        
    }
}