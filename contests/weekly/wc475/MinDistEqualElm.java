import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinDistEqualElm {
    public int minimumDistance(int[] nums) {

        if(nums.length<3){
            return -1;
        }
        Map<Integer, List<Integer>> indexmap= new HashMap<>();

        for(int i=0;i<nums.length;i++){
            indexmap.computeIfAbsent(nums[i], f->new ArrayList<>()).add(i);
        }

        int minDist= Integer.MAX_VALUE;

        for(List<Integer> idx:indexmap.values()){
            for(int i=0;i<=idx.size()-3;i++){
                int first= idx.get(i);
                int third= idx.get(i+2);

                int dist= 2*(third-first);

                minDist= Math.min(minDist,dist);

            }
        }
        return minDist==Integer.MAX_VALUE?-1:minDist;
    }

    public static void main(String[] args){
        int[] nums={1,1,2,3,2,1,2};
        MinDistEqualElm obj= new MinDistEqualElm();
        System.out.println(obj.minimumDistance(nums));
    }
}
