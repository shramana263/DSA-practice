public class DuplicateCheck {

    //time complexity: O(n^2)
    public boolean containsDuplicate(int[] nums) {
        // System.out.println("nums length: "+nums.length);
        if(nums.length==1) return false;
        int count=0;
        int candidate=nums[0];
        for(int i=0;i<nums.length-1;i++){ //nums.length-1 = 1
            for(int j=i+1;j<nums.length;j++){ //nums.length = 2
                // System.out.println("Comparing nums["+i+"]="+nums[i]+" and nums["+j+"]="+nums[j]);
                if(nums[i]==nums[j]){
                    // System.err.println("Found duplicate: "+nums[i]);
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[] nums = {3,3};
        DuplicateCheck dc = new DuplicateCheck();
        System.out.println(dc.containsDuplicate(nums));
    }
}
