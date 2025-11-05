import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiffOfArr {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<List<Integer>> finallist = new ArrayList<>();
        Map<Integer, Integer> map= new HashMap<>();
        int n1=nums1.length;
        int n2= nums2.length;

        for(int num:nums2){
            map.put(num,map.getOrDefault(num, 0)+1);
        }
        for(int i=0;i<n1;i++){
            if(!map.containsKey(nums1[i]) && !list2.contains(nums1[i])){
                list2.add(nums1[i]);
            }
        }
        finallist.add(list2);
        System.out.println("final1= "+finallist);
       
        map.clear();
         for(int num:nums1){
            map.put(num,map.getOrDefault(num, 0)+1);
        }

        for(int i=0;i<n2;i++){
            if(!map.containsKey(nums2[i]) && !list.contains(nums2[i])){
                list.add(nums2[i]);
            }
        }
        finallist.add(list);
        
        
        System.out.println("final2= "+finallist);
        
        return finallist;
    }

    public static void main(String[] args){

        int[] nums1={1,2,3};
        int[] nums2={2,4,6};

        DiffOfArr obj= new DiffOfArr();
        List<List<Integer>> diff = obj.findDifference(nums1, nums2);
        System.out.println(diff);
    }
}
