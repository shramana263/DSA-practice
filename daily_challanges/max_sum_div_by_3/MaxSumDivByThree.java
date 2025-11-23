public class MaxSumDivByThree {

    public int maxSum(int[] nums){
        // return 0;
        int n= nums.length;
        final int NEGATIVE_INFINITY= -(1<<30);
        if(n<1){
            return 0;
        }
        int[][] dp= new int[n+1][3];
        dp[0][1]= NEGATIVE_INFINITY;
        dp[0][2]=NEGATIVE_INFINITY;

        for(int i=1;i<=n;i++){
            int curr= nums[i-1];

            for(int rem=0;rem<3;rem++){
                int prev=(rem-(curr%3)+3)%3;

                dp[i][rem]= Math.max(dp[i-1][rem],dp[i-1][prev]+curr);
            }
        }
        return dp[n][0];
    }

    public static void main(String[] args){
        int[] nums={3,6,5,1,8};
        MaxSumDivByThree obj= new MaxSumDivByThree();
        System.out.println(obj.maxSum(nums));
    }
}
