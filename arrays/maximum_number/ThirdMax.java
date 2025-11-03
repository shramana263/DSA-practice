import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThirdMax {

    public int thirdMax(int[] nums) {

        if(nums==null || nums.length==0){
            return 0;
        }

        int n=nums.length;
        List<Integer> list = new ArrayList<>();
        for( int j=0;j<n;j++){
            if(!list.contains(nums[j])){
                list.add(nums[j]);
            }
        }
        Collections.sort(list);
        System.out.println(list);

        if(list.size()<3){
            return list.get(list.size()-1);
        }

        return list.get(list.size()-3);

    }

    public static void main(String[] args) {
        int[] nums= {};
        ThirdMax obj = new ThirdMax();
        System.out.println(obj.thirdMax(nums));

    }
}
