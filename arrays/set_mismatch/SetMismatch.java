import java.util.Arrays;

public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int expectedSum =  n * (n+ 1) / 2;
        System.out.println(expectedSum);
        int[] arr= new int[2];
        int sum=nums[0];
        for(int j=1;j<n;j++){
            // System.out.println("iteration no: "+j);
            if(nums[j]==nums[j-1]){
                arr[0]=nums[j];
                continue;
            }
            sum+=nums[j];
            
        }
        arr[1]=expectedSum-sum;
        return arr;
    }

    public static void main(String[] args){
        int[] nums= {3,2,3,4,6,5};
        SetMismatch obj = new SetMismatch();
        int[] ans= obj.findErrorNums(nums);
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }
    }
}
