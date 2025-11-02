
import java.util.ArrayList;
import java.util.List;

public class ArrIntersection {
    public int[] intersect(int[] nums1, int[] nums2) {

        if(nums1.length>nums2.length){
            return intersect(nums2, nums1);
        }

        List<Integer> list = new ArrayList<>();
        List<Integer> intersection = new ArrayList<>();
        // int[] intersection = new int[nums1.length];

        for(int num:nums1){
            list.add(num);
        }
        for(int i:nums2){
            if(list.contains(i)){
                // System.out.println("Before- "+ intersection +"   "+list);
                // intersection[k++]=i;
                intersection.add(i);
                list.remove(Integer.valueOf(i));
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
        ArrIntersection obj= new ArrIntersection();
        int[] result= obj.intersect(nums1, nums2);
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }
}
