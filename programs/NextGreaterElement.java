import java.util.*;
public class NextGreaterElement {
    // Brute-force approach: O(n^2)
    public static int[] nextGreaterElementBruteForce(int[] arr) {
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            boolean found = false;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    res[i] = arr[j];
                    found = true;
                    break;
                }
            }
            if (!found) {
                res[i] = -1;
            }
        }
        return res;
    }

    // Optimal approach: O(n) using Stack
    public static int[] nextGreaterElementOptimal(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> s = new Stack<>();

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Pop smaller or equal elements
            while (!s.isEmpty() && s.peek() <= arr[i]) {
                s.pop();
            }
            // If stack is empty, no greater element
            res[i] = s.isEmpty() ? -1 : s.peek();

            // Push current element
            s.push(arr[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {6, 8, 1, 4, 3, 7, 2};

        System.out.println("Brute Force Result:");
        int[] brute = nextGreaterElementBruteForce(arr);
        for (int val : brute) {
            System.out.print(val + " ");
        }

        System.out.println("\n\nOptimal Result:");
        int[] optimal = nextGreaterElementOptimal(arr);
        for (int val : optimal) {
            System.out.print(val + " ");
        }
    }
}
