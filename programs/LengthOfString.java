//Question 3 : Write a program to find Length of a String using Recursion.

public class LengthOfString 
{
    public static int LenOfString(String str)
    {
        if(str.length()==0)
        {
            return 0;
        }

        return LenOfString(str.substring(1))+1;
    }
    public static void main(String Args[])
    {
        String str="HIMANSHU TRIPATHI";
        System.out.println("The length of the string is : "+LenOfString(str));
    }
    
}
