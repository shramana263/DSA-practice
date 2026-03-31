
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LongestBalanced2 {
    public int longestBalanced(String s) {
        int n= s.length();
        Map<Character,Integer> map= new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1 );
        }
        int max = Collections.max(map.values());
        int frequency = Collections.frequency(map.values(),max);
        // System.out.println(max*frequency);
        return max*frequency;
    }
    public static void main(String args[]){
        String s = "abbac";
        LongestBalanced2 obj = new LongestBalanced2();
        System.out.println(obj.longestBalanced(s));
    }
}
