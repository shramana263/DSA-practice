public class RemoveElem {
    //time complexity: O(n)
    public int removeElement(int[] nums, int val) {
     
        if(nums==null || nums.length==0){
            return 0;
        }
        int i=0;
        for(int j=0;j<nums.length;j++){
            if(nums[j]!=val){
                nums[i]=nums[j];
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args){
        int[] nums = {3,2,2,3};
        int val = 3;
        int k = new RemoveElem().removeElement(nums, val);
        int[] expectedNums = {2,2}; // The expected answer with correct length
        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }
        System.out.println("All assertions passed.");
    }
}
