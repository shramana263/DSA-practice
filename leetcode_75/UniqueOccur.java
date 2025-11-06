
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueOccur {
    public boolean uniqueOccurrences(int[] arr) {

        if(arr.length==0){
            return false;
        }
        int n=arr.length;
        Map<Integer, Integer> map= new HashMap<>();
        Set<Integer> unique = new HashSet<>();
        for( int i=0;i<n;i++){
            map.put(arr[i],map.getOrDefault(arr[i], 0)+1);
        }

        // System.out.println(map);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
            if(unique.contains(entry.getValue())){
                return false;
            }
            else{
                unique.add(entry.getValue());
            }
        }

        return true;

    }
    public static void main(String[] args){
        int[] nums={1,2,2,2,1,1,3};
        UniqueOccur obj = new UniqueOccur();
        System.out.println(obj.uniqueOccurrences(nums)?"true":"false");
    }
}
