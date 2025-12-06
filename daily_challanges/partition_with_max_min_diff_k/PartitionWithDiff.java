
public class PartitionWithDiff {
    // public int countPartitions(int[] nums, int k) {
    //     int n= nums.length;
    //     int count=1;
    //     List<Integer> list= new ArrayList<>();
    //     // list.add(nums[0]);
    //     for(int i=0;i<n;i++){
    //         list.add(nums[i]);
    //         int min=nums[i];
    //         int max= nums[i];
    //         for(int j=i+1;j<n;j++){
    //             list.add(nums[j]);
    //             if(nums[j]<min){
    //                 min=nums[j];
    //             }
    //             else if(nums[j]>max){
    //                 max=nums[j];
    //             }
    //             if(max-min<=k){
    //                 System.out.println(list);
    //                 count++;
    //             }
    //             else{
    //                 break;
    //             }
    //         }
    //         list.clear();

    //     }
    //     return count;
    // }
    
    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        int MOD = 1_000_000_007;

        long[] DP = new long[n + 1];

        DP[0] = 1;

        for (int i = 1; i <= n; i++) {
            int maxVal = nums[i - 1];
            int minVal = nums[i - 1];

            for (int j = i - 1; j >= 0; j--) {
                if (j < i - 1) {
                    maxVal = Math.max(maxVal, nums[j]);
                    minVal = Math.min(minVal, nums[j]);
                }
                
                if (maxVal - minVal <= k) {
                    DP[i] = (DP[i] + DP[j]) % MOD;
                } else {
                    break;
                }
            }
        }

        return (int) DP[n];
    }

    public static void main(String[] args) {
        int[] nums ={9,4,1,3,7};
        int k=4;
        PartitionWithDiff obj = new PartitionWithDiff();
        System.out.println(obj.countPartitions(nums, k));
    }

}
