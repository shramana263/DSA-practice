import java.util.Set;

public class MaxVowelSubArr {

    public int maxVowels(String s, int k) {
        int count=0;
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        
        for(int i=0;i<k;i++){
            if(vowels.contains(s.charAt(i))){
                count++;
            }
        }
        int maxVowel=count;
        for(int i=k;i<s.length();i++){
            if(vowels.contains(s.charAt(i))){
                count++;
            }
            if(vowels.contains(s.charAt(i - k))){
                count--;
            }
            if(count > maxVowel){
                maxVowel = count;
            }
        }

        return maxVowel;
    }

    public static void main(String[] args) {
        MaxVowelSubArr obj = new MaxVowelSubArr();
        String s= "leetcode";
        int k=3;
        System.out.println(obj.maxVowels(s, k));
    }
}
