public class MinOperationToDivByThree {
    public int minimumOperations(int[] nums) {
        // int nx=nums.length;
        int countOperation=0;
        for(int n:nums){
            int rem = n%3;
            countOperation+=Math.min(rem, 3-rem);
        }
        return countOperation;
    }
}
