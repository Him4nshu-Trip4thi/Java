import java.util.*;

public class UniqueArrayPermutation {
    private static List<List<Integer>> result;
    private static int[] nums;

    public static List<List<Integer>> permuteUnique(int[] inputNums) {
        result = new ArrayList<>();
        nums = inputNums;  // Assign input array to the class-level nums array
        Arrays.sort(nums);  // Sort to group duplicates together
        backtrack(0);
        return result;
    }

    private static void backtrack(int start) {
        if (start == nums.length) {
            result.add(arrayToList(nums));
            return;
        }

        Set<Integer> used = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (used.contains(nums[i])) {
                continue;
            }
            used.add(nums[i]);
            swap(start, i);
            backtrack(start + 1);
            swap(start, i);  // backtrack
        }
    }

    private static void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static List<Integer> arrayToList(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }
        return list;
    }

    public static void main (String[] Args){
        int arr[] = {1, 2, 3, 4, 5};
        List<List<Integer>> result = permuteUnique(arr);

        System.out.println("Permutations:");
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
