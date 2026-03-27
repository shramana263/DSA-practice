/* Find occurance of a character in a string
    Input
    --------------
 *  Priyanka
 *  a
 
 *  Output
    ----------------
 *  2
 */
import java.util.Scanner;
public class CharFrequency {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        String str= sc.nextLine();
        char ch= sc.nextLine().charAt(0);

        int count=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==ch){
                count++;
            }
        }
        System.out.println(count);
        sc.close();
    }
}
