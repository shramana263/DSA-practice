
import java.util.Arrays;

public class CloseStrings{

    public boolean closeStrings(String word1, String word2) {


        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for(int i=0;i<word1.length();i++){
            freq1[word1.charAt(i)-'a']++;
        }

        for(int i=0;i<word2.length();i++){
            freq2[word2.charAt(i)-'a']++;
        }

        for(int i=0;i<26;i++){
            if((freq1[i]==0)!=(freq2[i]==0)){
                return false;
            }
        }

        Arrays.sort(freq1);
        Arrays.sort(freq2);

        return Arrays.equals(freq1, freq2);
    }

    public static void main(String[] args){
        String word1= "a";
        String word2= "aa";
        CloseStrings obj = new CloseStrings();
        System.out.println(obj.closeStrings(word1, word2)?"true":"false");
    }
}