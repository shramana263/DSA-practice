
import java.util.HashMap;
import java.util.Map;

public class MaxKsumPairs {

    public int maxOperations(int[] nums, int k) {
        if(nums.length<1){
            return 0;
        }
        int n= nums.length;
        Map<Integer,Integer> map= new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int count=0;

        for(int i=0;i<n;i++){
            if (map.getOrDefault(nums[i], 0) <= 0) {
                continue; // Skip if already used up
            }
            int complement= k-nums[i];
            if(map.containsKey(complement)){

                if(nums[i]==complement){
                    if(map.get(complement)>=2){
                        count++;
                        map.put(nums[i],map.get(nums[i])-2);
                    }
                }
                else{
                    if(map.getOrDefault(complement, 0)>0){
                        count++;
                        map.put(nums[i],map.get(nums[i])-1);
                        map.put(complement, map.get(complement)-1);
                    }
                }
            }
        }


        return count;
    }

    public static void main(String[] args){
        int[] nums= {2,5,4,4,1,3,4,4,1,4,4,1,2,1,2,2,3,2,4,2};
        int k=8;

        MaxKsumPairs obj= new MaxKsumPairs();
        System.out.println(obj.maxOperations(nums, k));

    }
}
