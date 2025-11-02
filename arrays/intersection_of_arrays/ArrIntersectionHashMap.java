import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrIntersectionHashMap {
    public int[] intersect(int[] nums1, int[] nums2) {

        if(nums1.length>nums2.length){
            return intersect(nums2, nums1);
        }

        Map<Integer, Integer> list = new HashMap<>();
        List<Integer> intersection = new ArrayList<>();
        // int[] intersection = new int[nums1.length];

        for(int num:nums1){
            list.put(num,list.getOrDefault(num, 0)+1);
        }
        for(int i:nums2){
            if(list.containsKey(i)&& list.get(i)>0){
                // System.out.println("Before- "+ intersection +"   "+list);
                // intersection[k++]=i;
                intersection.add(i);
                list.put(i, list.get(i)-1);
                // System.out.println("After- "+ intersection +"   "+list);
            }
        }
        // convert List<Integer> to int[]
        int[] result = new int[intersection.size()];
        for (int k = 0; k < intersection.size(); k++) {
            result[k] = intersection.get(k);
        }
        return result;

    }

    public static void main(String[] args){
        int[] nums1={1,2,2,1};
        int[] nums2={2,2};
        ArrIntersectionHashMap obj= new ArrIntersectionHashMap();
        int[] result= obj.intersect(nums1, nums2);
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }
}
