public class MaxConsecutiveOne {

    public int longestOnes(int[] nums, int k) {
        if(nums.length<1){
            return 0;
        }
        int left=0;
        int count=0;
        for(int num:nums){
            count+= num^1;

            if(count>k){
                count-=nums[left]^1;
                left++;
            }
        }
        return nums.length-left;
    }

    public static void main(String[] args){
        int[] nums={1,1,0,1};
        int k=1;
        MaxConsecutiveOne obj = new MaxConsecutiveOne();
        System.out.println(obj.longestOnes(nums, k));
    }
}
