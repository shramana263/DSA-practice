
import java.util.HashMap;

public class LargestSubstrWithoutRepeatingChar {

    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLength = 0;
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            if (map.containsKey(currentChar)) {
                left = Math.max(map.get(currentChar) + 1, left);
            }
            map.put(currentChar, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
        
    }

    public static void main(String[] args){
        String s= new String("aabcbabdbb");
        LargestSubstrWithoutRepeatingChar obj = new LargestSubstrWithoutRepeatingChar();
        int length = obj.lengthOfLongestSubstring(s);
        System.out.println("The length of largest substring without repeating character is: "+ length);
    }
}
