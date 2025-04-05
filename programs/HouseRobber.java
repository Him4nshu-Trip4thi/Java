/*
198. House Robber

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

Example 1:
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.

Example 2:
Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
 
Constraints:
1 <= nums.length <= 100
0 <= nums[i] <= 400 */

public class HouseRobber
{
    public static int MaxRobbedMoney(int nums[]) 
    {
        int n=nums.length;

        if(n==0)
        {
            return 0;
        }

        if(n==1)
        {
            return nums[0];
        }

        int result[]=new int[n]; //storing the maximum amount robbed up to the i-th house
        result[0]=nums[0];
        result[1]=Math.max(nums[0],nums[1]);

        for(int i=2;i<n;i++)
        {
            result[i]=Math.max(result[i-1],result[i-2]+nums[i]); //max of (amount robbed up to the (i-1)th house) and (amount robbed up to the (i-2)th house + the money in the current house)
        }

        return result[n-1];
    }

    public static void main(String Args[])
    {
        int TC1[]={1,2,3,1};
        int TC2[]={2,7,9,3,1};
        int TC3[]={2,1,1,2};

        System.out.println("Maximum amount of money that can be robbed : " + MaxRobbedMoney(TC1));
        System.out.println("Maximum amount of money that can be robbed : " + MaxRobbedMoney(TC2));
        System.out.println("Maximum amount of money that can be robbed : " + MaxRobbedMoney(TC3));


    }
}

