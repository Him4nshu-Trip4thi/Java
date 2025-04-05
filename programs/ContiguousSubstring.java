//Question4: We are given a string S, we need to find the count of all contiguous substrings starting and ending with the same character.

//Sample Input 1: S = "abcab"
//Sample Output 1: 7
//There are 15 substrings of "abcab" : a, ab, abc, abca, abcab, b, bc, bca, bcab, c, ca, cab, a, ab, b.
//Out of the above substrings, there are 7 substrings: a, abca, b, bcab, c, aandb.
//So, only 7 contiguous substrings start and end with the same character.

//Sample Input 2: S = "aba"
//Sample Output 2: 4
//The substrings are a, b, a and aba.
 

public class ContiguousSubstring 
{
    public static int Substring(String str,int i, int j, int n)
    {
        if(n<=0)
        {
            return 0;
        }
        if(n==1)
        {
            return 1;
        }
        int res=Substring(str, i+1, j, n-1)+Substring(str, i, j-1, n-1)-Substring(str, i+1, j-1, n-2);

        if(str.charAt(i)==str.charAt(j))
        {
            res++;
        }
        return res;
    }
    public static void main(String Args[])
    {

        String str1="abcab";
        int n=str1.length();
        System.out.println("The contiguous substring of str1 : "+Substring(str1,0,n-1,n));

        String str2="aba";
        n=str2.length();
        System.out.println("The contiguous substring of str2 : "+Substring(str2,0,n-1,n));
        

    }

    
}
