/* Find Characters of a string at odd index
 * Arijit = rjt
 * priyanka = ryna
*/

import java.util.Scanner;
public class CharOdd {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String str= sc.nextLine();
    
        for(int i=0;i<str.length();i++){
            if(i%2!=0){
                System.out.print(str.charAt(i));
            }
        }
        sc.close();
    }
}
