/*Given a sentence, Find words that start with a capital letter.

For example, in the sentence "The quick Brown Fox jumps over the lazy dog", there are three words that start with a 
capital letter: "The", "Brown", and "Fox". */
import java.util.Scanner;
public class FindCapitalize {
    public static void main(String[] ags){
        Scanner sc  = new Scanner(System.in);
        String s= sc.nextLine();
        String[] arr=s.split(" ");
        for(String a:arr){
            if(Character.isUpperCase(a.charAt(0))){
                System.out.print(a+" , ");
            }
        }
        sc.close();
    }
    
}
