
import java.util.HashSet;
import java.util.Set;

public class DuplicateCheckIISet {

    public boolean containsNearbyDuplicate(int[] nums, int k){
        if(nums.length==1){
            return false;
        }
        Set<Integer> window= new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(window.contains(nums[i])){
                return true;
            }
            window.add(nums[i]);

            if(i>=k){
                window.remove(nums[i-k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums={1,0,1,1};
        int k=1;
        DuplicateCheckIISet obj= new DuplicateCheckIISet();
        boolean result = obj.containsNearbyDuplicate(nums, k);
        System.out.println("Duplicate check: "+ result);
        
    }
}
