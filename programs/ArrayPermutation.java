import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayPermutation {
    static List<int[]> permutations = new ArrayList<>();

    public static void findPermutations(int[] arr, int[] ans, boolean[] used, int depth) {
        // Base case: if the answer array is full, store the permutation
        if (depth == arr.length) {
            permutations.add(ans.clone());
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!used[i]) {
                used[i] = true;
                ans[depth] = arr[i];
                findPermutations(arr, ans, used, depth + 1);
                used[i] = false;  // Backtrack
            }
        }
    }

    public static int[][] getPermutations(int[] arr) {
        int[] ans = new int[arr.length];
        boolean[] used = new boolean[arr.length];
        
        findPermutations(arr, ans, used, 0);
        
        int[][] result = new int[permutations.size()][arr.length];
        for (int i = 0; i < permutations.size(); i++) {
            result[i] = permutations.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        
        int[][] result = getPermutations(arr);

        System.out.println("Permutations:");
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
