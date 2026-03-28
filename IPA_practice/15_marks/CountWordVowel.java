/* Count the words in a sentence which are start with vowel. 
 * 
 * Input: Arijit is student of MCA
 * Output: 3
 * 
 * Input: Sara plays tennis
 * Output: No such words
*/
import java.util.Scanner;
public class CountWordVowel {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        String s= sc.nextLine().toLowerCase();
        String[] str= s.split(" ");
        int count=0;
        for(String st:str){
            if(isVowel(st.charAt(0))){
                count++;
            }
        }
        System.out.println(count);
        sc.close();
    }

    public static boolean isVowel(char ch){
        if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
            return true;
        }
        return false;
    }
}
