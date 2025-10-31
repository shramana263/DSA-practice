
import java.util.Arrays;

public class ThreeSumClosestOpt {
    //time complexity O(n^2)
    public int threeSumClosest(int[] nums, int target) {
        if(nums==null || nums.length<3){
            return 0;
        }

        Arrays.sort(nums);
        int n= nums.length;
        int closest= nums[0]+nums[1]+nums[2];
        for(int i=0;i<n-2;i++){
            if(i!=0 && nums[i]==nums[i-1]){
                continue;
            }
            int j=i+1;
            int k=n-1;
            while(j<k){
                int current= nums[i]+nums[j]+nums[k];
                if(Math.abs(target-closest)>Math.abs(target-current)){
                    closest=current;
                }
                if(current==target){
                    return current;
                }
                else if(current<target){
                    j++;
                    while(j<k && nums[j]==nums[j-1]){
                        j++;
                    }
                }
                else{
                    k--;
                    while(j<k && nums[k]==nums[k+1]){
                        k--;
                    }
                }

            }
        }

        return closest;
    }

    public static void main(String[] args) {
        int[] nums={-1,2,1,-4,-4,-4};
        int target =1;
        ThreeSumClosestOpt obj = new ThreeSumClosestOpt();
        System.out.println(obj.threeSumClosest(nums, target));
    }
}
