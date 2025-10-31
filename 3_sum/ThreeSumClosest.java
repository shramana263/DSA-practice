
import java.util.Arrays;

public class ThreeSumClosest {
    //time complexity O(n^2)
    public int threeSumClosest(int[] nums, int target) {
        if(nums==null || nums.length<3){
            return 0;
        }

        Arrays.sort(nums);
        int n= nums.length;
        int diff=Integer.MAX_VALUE;
        int newDiff= Integer.MAX_VALUE;
        int sum=0;
        int result=0;
        for(int i=0;i<n;i++){
            int j=i+1;
            int k=n-1;
            while(j<k){
                sum= nums[i]+nums[j]+nums[k];
                newDiff=Math.min(newDiff, Math.abs(target - sum));
                if(newDiff<diff){
                    diff= newDiff;
                    result=sum;
                    System.out.println("updated result: "+result);
                }
                System.out.println("sum: "+sum+" newDiff: "+newDiff);
                if(diff==0){
                    return sum;
                }
                if(sum<target){
                    j++;  
                }
                else{
                    k--;
                }


            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums={-1,2,1,-4,-4,-4};
        int target =1;
        ThreeSumClosest obj = new ThreeSumClosest();
        System.out.println(obj.threeSumClosest(nums, target));
    }
}
