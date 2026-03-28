/*Count the number of words in a sentence that contain at least two consecutive vowels (a, e, i, o, u) in them.
Here's a sample input and output:

Input: I enjoy eating spaghetti and meatballs for dinner
Output: 2

Explanation: There are two words in the sentence that contain at least two consecutive vowels - "enjoy" and "meatballs".
 */
import java.util.Scanner;
public class ConsecutiveVow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str= sc.nextLine().toLowerCase();
        String[] s= str.split(" ");

        // for(int i=0;i<s.length;i++){
        //     System.out.println(s[i]);
        // }

        for(int i=0;i<s.length;i++){
            for(int j=0;j<s[i].length()-1;j++){
                if(isVowel(s[i].charAt(j)) && isVowel(s[i].charAt(j+1))){
                    System.out.println(s[i]);
                    // continue;
                }
            }
        }
        sc.close();
    }

    public static boolean isVowel(char ch){
        if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
            return true;
        }
        return false;
    }
}
