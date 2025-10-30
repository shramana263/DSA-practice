
import java.util.ArrayList;

public class ReverseVowelsStr {
    // Given a string s, reverse only all the vowels in the string and return it.

    // The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

    

    // Example 1:

    // Input: s = "IceCreAm"

    // Output: "AceCreIm"

    // Explanation:

    // The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".

    // Example 2:

    // Input: s = "leetcode"

    // Output: "leotcede"

    private boolean isVowel(char c){
        c= Character.toLowerCase(c);
        return c=='a' || c=='e' || c=='i' || c=='o' || c=='u';
    }
    //time complexity O(n)
    public String reverseVowels(String s) {
        if(s==null||s.length()<=1){
            return s;
        }
        ArrayList<Character> vowels = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(isVowel(s.charAt(i))){
                vowels.add(s.charAt(i));
            }
        }
        // System.out.println(vowels);
        int j=vowels.size()-1;
        for(int i=0;i<s.length();i++){
            if(isVowel(s.charAt(i))){
                char ch= vowels.get(j);
                s= s.substring(0,i)+ch+s.substring(i+1);
                j--;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        ReverseVowelsStr obj = new ReverseVowelsStr();
        System.out.println(obj.reverseVowels(s));
    }

}
