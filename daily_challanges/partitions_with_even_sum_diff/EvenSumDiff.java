public class EvenSumDiff {
    public int countPartitions(int[] nums) {
        int n= nums.length;
        if(n<1){
            return 0;
        }
        int left=nums[0];
        int sum=0;
        int count=0;
        for(int num:nums){
            sum+=num;
        }
        sum-=left;
        // if((sum-left)%2==0){
        //     count++;
        // }
        for(int i=1;i<n;i++){
            left+=nums[i];
            sum-=nums[i];
            if((sum-left)%2==0){
                count++;
            }
        }
        return count;
    }
    public static void main(String args[]){
        int[] nums={10,10,3,7,6};
        EvenSumDiff obj = new EvenSumDiff();
        System.out.println(obj.countPartitions(nums));
    }
}
