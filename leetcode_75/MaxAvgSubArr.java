

public class MaxAvgSubArr {

    public double findMaxAverage(int[] nums, int k) {
        long sum = 0; 
        int n = nums.length;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        long maxSum = sum; 
        for (int i = k; i < n; i++) {
            sum = sum + nums[i] - nums[i - k]; 
            
            maxSum = Math.max(maxSum, sum);
        }

        return (double) maxSum / k;
    }

    public static void main(String[] args){
        int[] nums = {-1};
        int k=1;
        MaxAvgSubArr obj= new MaxAvgSubArr();
        System.out.println(obj.findMaxAverage(nums,k));
    }
}
