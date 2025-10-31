
import java.util.HashSet;
import java.util.Set;

public class DuplicateCheckOpt {

    public boolean containsDuplicate(int[] nums){
        Set<Integer> seen = new HashSet<>();
        for(int num:nums){
            if(seen.contains(num)){
                return true;
            }
            seen.add(num);
        }
        return false;
    }

    public static void main(String[] args){
        int[] nums = {3,3};
        DuplicateCheck dc = new DuplicateCheck();
        System.out.println(dc.containsDuplicate(nums));
    }
}
