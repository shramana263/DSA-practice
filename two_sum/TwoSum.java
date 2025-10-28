// package two_sum;

import java.util.Arrays;

public class TwoSum {
    //Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

    // You may assume that each input would have exactly one solution, and you may not use the same element twice.

    // You can return the answer in any order.
    // Example 1:

    // Input: nums = [2,7,11,15], target = 9
    // Output: [0,1]
    // Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
    // Example 2:

    // Input: nums = [3,2,4], target = 6
    // Output: [1,2]
    // Example 3:

    // Input: nums = [3,3], target = 6
    // Output: [0,1]
    

    // Constraints:

    // 2 <= nums.length <= 104
    // -109 <= nums[i] <= 109
    // -109 <= target <= 109
    // Only one valid answer exists.
    // Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?


    //time complexity: O(n^2)

    // public static int[] twoSum(int[] nums, int target) {
    //     for(int i=0;i<nums.length;i++){
    //         for(int j=i+1;j<nums.length;j++){
    //             if(nums[i]+nums[j]==target){
    //                 return new int[]{i,j};
    //             }
    //         }
    //     }
    //     return new int[]{-1,-1};
    // }

    //time complexity: O(nlogn)
    public static int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int start= 0;
        int end = nums.length-1;
        while(start<end){
            if(nums[start]+nums[end]==target){
                return new int[]{start,end};
            }
            else if(nums[start]+nums[end]<target){
                start++;
            }
            else{
                end--;
            }
        }
        return new int[]{-1,-1};
    }


    public static void main(String[] args){
        int[] nums={3,2,4};
        int target=6;
        int[] result= twoSum(nums, target);
        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
    }

}
