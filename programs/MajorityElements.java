// Question 2 :
// Given an array nums of size n, return the majority element.
// The majority element is the element that appears more than [n/2] times.
// You may assume that the majority element always exists in the array.

// Sample Input 1: nums = [3,2,3]
// Sample Output 1: 3
// Sample Input 2: nums = [2,2,1,1,1,2,2]
// Sample Output 2: 2

// Constraints(extra Conditions):
// ●n == nums.length
// ●1 <= n <= 5 * 104
// ●-109 <= nums[i] <= 109



public class MajorityElements 
{
    public static void main (String Args[])
    {
        int nums[]={2,2,1,1,1,2,2};

        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            if(max<nums[i])
            {
                max=nums[i];
            }
        }

        int arr[]=new int[max+1];

        for(int i=0;i<nums.length;i++)
        {
            arr[nums[i]]++;
        }

        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>nums.length/2)
            {
                System.out.println("The majority element is : "+ i + " with count of " + arr[i]);
                break;
            }
        }
    }
}
