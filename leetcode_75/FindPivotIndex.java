public class FindPivotIndex {

    public int pivotIndex(int[] nums) {
        if(nums.length==0){
            return -1;
        }
        // if(nums.length==1){
        //     return nums[0];
        // }
        int n=nums.length;
        int leftsum=0;
        int rightsum=0;

        for(int i=0;i<n;i++){
            int pivot=nums[i];
            for(int j=i-1;j>=0;j--){
                leftsum+=nums[j];
            }
            for(int k=i+1;k<n;k++){
                rightsum+=nums[k];
            }

            if(leftsum==rightsum){
                return i;
            }
            leftsum=0;
            rightsum=0;
        }

        return -1;
    }

    public static void main(String[] args){

        int[] nums= {4};
        FindPivotIndex obj= new FindPivotIndex();
        System.out.println(obj.pivotIndex(nums));
        
    }
}
