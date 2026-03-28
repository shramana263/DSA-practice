/* Find the characters in odd position of a string which are consonent
 * 
 * Input: Arijit Ghosh
 * Output: hs
 */
import java.util.Scanner;
public class ConsonantOddPos {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        String str= sc.nextLine();
        for(int i=2;i<str.length();i++){
            // System.out.println("i = "+i +" char = "+str.charAt(i));
            if(i%2==0 && isConsonant(str.charAt(i)) && str.charAt(i)!=' '){
                System.out.print(str.charAt(i));
            }
        }
        sc.close();
    }

    public static boolean isConsonant(char ch){
        return ch!='a' && ch!='e' && ch!='i' && ch!='o' && ch!='u';
    }
}
