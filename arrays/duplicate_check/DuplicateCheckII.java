
import java.util.HashMap;
import java.util.Map;

public class DuplicateCheckII {

    // Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
    // Example 1:

    // Input: nums = [1,2,3,1], k = 3
    // Output: true
    // Example 2:

    // Input: nums = [1,0,1,1], k = 1
    // Output: true
    // Example 3:

    // Input: nums = [1,2,3,1,2,3], k = 2
    // Output: false

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length==1){
            return false;
        }
        Map<Integer,Integer> duplicate = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            System.out.println("Hello");
            // if(i==0){
            //     duplicate.put(nums[0],0);
            // }
            if(duplicate.containsKey(nums[i])){
                System.out.println("nums[i]: "+ nums[i] + "   i: "+i);
                System.out.println("nums[i]: "+ i + "stored i: "+duplicate.get(nums[i]));
                if(i - duplicate.get(nums[i]) <= k){
                    return true;
                }
                duplicate.put(nums[i], i);
            }
            else{
                duplicate.put(nums[i],i);
                System.out.println("map: "+duplicate);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums={1,0,1,1};
        int k=1;
        DuplicateCheckII obj= new DuplicateCheckII();
        boolean result = obj.containsNearbyDuplicate(nums, k);
        System.out.println("Duplicate check: "+ result);
        
    }
}
