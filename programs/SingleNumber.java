//136. Single SingleNumber

/*
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.

 

Example 1:

Input: nums = [2,2,1]
Output: 1

Example 2:

Input: nums = [4,1,2,1,2]
Output: 4

Example 3:

Input: nums = [1]
Output: 1
 

Constraints:

1 <= nums.length <= 3 * 104
-3 * 104 <= nums[i] <= 3 * 104

Each element in the array appears twice except for one element which appears only once.
*/



public class SingleNumber
{
    public static int findSingleFREQ(int arr[])
    {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            max=Math.max(max, arr[i]);
        }

        int freq[]=new int[max+1];

        for(int i=0;i<arr.length;i++)
        {
            freq[arr[i]]++;
        }

        for(int i=0;i<arr.length;i++)
        {
            if(freq[arr[i]]==1)
            {
                return arr[i];
            }
        }
        return -1;
    }

    public static int findSingleXOR(int arr[])
    {
        int XOR=0;
        for(int i=0;i<arr.length;i++)
        {
            XOR=XOR^arr[i];
        }
        if(XOR==0)
        {
            return -1;
        }
        return XOR;
    }

    public static void main(String Args[])
    {
        int arr[]={4,4,2,5,6,5,6,1,2,9,1,9};

        int singleNumFREQ=findSingleFREQ(arr);
        int singleNumXOR=findSingleXOR(arr);

        System.out.print("The only single number present in the array using frequency method is : "+singleNumFREQ);
        System.out.println();
        System.out.print("The only single number present in the array using XOR(optimal) method is : "+singleNumXOR);

    }
    
}
