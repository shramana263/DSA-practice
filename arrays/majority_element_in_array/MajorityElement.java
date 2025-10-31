public class MajorityElement {
// Given an array nums of size n, return the majority element.

// The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 

// Example 1:

// Input: nums = [3,2,3]
// Output: 3
// Example 2:

// Input: nums = [2,2,1,1,1,2,2]
// Output: 2

    public int majorityElement(int[] nums) {
        if(nums.length==0) return 0;
        int count=0;
        int num=0;
        for(int n:nums){
            if(count==0){
                count=1;
                num=n;
            }
            else if(n==num){
                count++;
            }
            else{
                count--;
            }
        }
        return num;
    }

    public static void main(String[] args){
        int[] nums = {2,2,1,1,1,2,2};
        MajorityElement me = new MajorityElement();
        System.out.println(me.majorityElement(nums));
    }
    

}
