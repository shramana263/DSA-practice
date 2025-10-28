import java.util.HashMap;
import java.util.Map;

public class TwoSumHashMap {

    public static int[] twoSum(int[] nums, int target){

        Map<Integer,Integer> m= new HashMap<>(); 
        for(int i=0;i<nums.length;i++){
            int complement= target - nums[i];
            if(m.containsKey(complement)){
                return new int[]{m.get(complement),i};
            }
            m.put(nums[i],i);
        }
        return new int[]{-1,-1};
    } 

    public static void main(String[] args){
        int[] nums={3,2,4};
        int target=6;
        int[] result= twoSum(nums,target);
        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
    }
}
