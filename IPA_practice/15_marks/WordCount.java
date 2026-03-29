/* Input : Home, Sweet Home
           Home
 * Output : Number of that word present in the sentence : 2
 * 
 * Process
 * ----------
 * The word Home present in the sentence 2 times
 */
import java.util.Scanner;
public class WordCount {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        String s= sc.nextLine();
        String w= sc.nextLine();
        String[] arr= s.split("[ ,]+");
        int count=0;
        for(String a:arr){
            if(a.equals(w)){
                count++;
            }
        }
        System.out.println(count);
        sc.close();
    }
}
