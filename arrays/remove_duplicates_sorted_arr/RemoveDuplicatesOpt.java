public class RemoveDuplicatesOpt {
    //time complexity: O(n)
    public int removeDuplicates(int[] nums){
        
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i=0;

        for(int j=0;j<nums.length;j++){
            if(nums[j]!=nums[i]){
                i++;
                nums[i]=nums[j];
            }
        }
        return i+1;
    }
    
    public static void main(String[] args){
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int[] expectedNums = {0,1,2,3,4}; // The expected answer with correct length
        int k = new RemoveDuplicatesOpt().removeDuplicates(nums); // Calls your implementation
        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }
        System.out.println("All assertions passed.");
    }
}
