import java.util.*;
public class MinAbsoluteDiffPair {
    public static int minDiffPair(int A[], int B[]){
        int minSum=0;
        Arrays.sort(A);
        Arrays.sort(B);

        for(int i=0;i<A.length;i++){
            minSum+=Math.abs(A[i]-B[i]);
        }
        return minSum;
    }

    public static void main (String args[]){
        int A[]={4,1,8,7};
        int B[]={2,3,6,5};

        System.out.println("The minimum absolute difference pairing is: "+minDiffPair(A,B));
    }
}
