public class FindPivotIndexOpt {

    public int pivotIndex(int[] nums) {
        if(nums.length==0){
            return -1;
        }
        // if(nums.length==1){
        //     return nums[0];
        // }
        int totalsum=0;
        for(int num:nums){
            totalsum+=num;
        }
        int n=nums.length;
        int psum=0;
        for(int i=0;i<n;i++){
            psum+=nums[i];
            int curr= totalsum-psum;
            // System.out.println("psum : "+psum +"  current : "+curr);
            if((psum-nums[i])==curr){
                return i;
            }

        }
        return -1;
    }

    public static void main(String[] args){

        int[] nums= {2,1,-1};
        FindPivotIndexOpt obj= new FindPivotIndexOpt();
        System.out.println(obj.pivotIndex(nums));
        
    }
}
