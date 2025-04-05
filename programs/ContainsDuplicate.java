/*
217. Contains Duplicate

Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

Example 1:
Input: nums = [1,2,3,1]
Output: true

Example 2:
Input: nums = [1,2,3,4]
Output: false

Example 3:
Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true
 
Constraints:
1 <= nums.length <= 105
-109 <= nums[i] <= 109
*/

import java.util.*;

public class ContainsDuplicate
{
    public static boolean Occurence(int nums[]) //Failing for negative values 
    {
        int freq[]=new int[nums.length+1];
        for(int i=0;i<nums.length;i++)
        {
            freq[nums[i]]++;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(freq[i]>1)
            {
                return true;
            }
        }
        return false;
    }

    public static boolean DuplicateSetCheck(int nums[]) //Successful for both +ve & -ve
    {
        HashSet<Integer> Set=new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            if(Set.contains(nums[i]))
            {
                return true;
            }
            else
            {
                Set.add(nums[i]);
            }
        }
        return false;
    }
    public static void main(String Args[])
    {
        int TC1[]={1,2,3,1};
        int TC2[]={1,2,3,4};
        int TC3[]={1,1,1,3,3,4,3,2,4,2};
        int TC4[]={1,5,-2,-4,0};
        int TC5[]={1,-2,-2,2,3,4,6,5,5,8,-1,2};
        int TC6[]={1,5,6,9,-2,-1,-6};

        boolean TR1=Occurence(TC1);
        boolean TR2=Occurence(TC2);
        boolean TR3=Occurence(TC3);
        boolean TR4=DuplicateSetCheck(TC4);
        boolean TR5=DuplicateSetCheck(TC5);
        boolean TR6=DuplicateSetCheck(TC6);

        
        System.out.println(TR1);
        System.out.println(TR2);
        System.out.println(TR3);
        System.out.println(TR4);
        System.out.println(TR5);
        System.out.println(TR6);
    }
}