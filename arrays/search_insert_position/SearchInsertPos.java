public class SearchInsertPos {
    //time complexity: O(n)
    public int searchInsert(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                return i;
            } else if(nums[i] > target){
                return i;
            }
        }
        return 0;

    }

    public static void main(String[] args){
        int[] nums= {1,3,6,6};
        int target = 5;
        SearchInsertPos sip = new SearchInsertPos();
        int result = sip.searchInsert(nums, target);
        System.out.println("The target " + target + " should be inserted at index: " + result);
    }
}
