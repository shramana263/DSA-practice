public class RangeSumQuery {
    private int[] data;
    public RangeSumQuery(int[] nums) {
        
        this.data = new int[nums.length]; 
        for (int i = 0; i < nums.length; i++) {
            this.data[i] = nums[i]; 
        }
       
    }
    
    public int sumRange(int left, int right) {
        int sum=0;
        for(int i=left;i<=right;i++){
            sum+=data[i];
        }
        return sum;
    }
}
