
import java.util.Scanner;

public class MergeStringsAlternatively {

    //String concatenation approach -> 6ms run time in leetcode

    // public String mergeAlternately(String w1, String w2){
    //     String result= new String();

    //     for(int i=0;i<w1.length() || i<w2.length(); i++){
    //         if(i<w1.length()){
    //             result+=w1.charAt(i);
    //         }
    //         if(i<w2.length()){
    //             result+=w2.charAt(i);
    //         }
    //     }

    //     return result;
    // }


    //StringBuilder approach -> 0ms run time in leetcode
    public String mergeAlternately(String w1, String w2){
        StringBuilder result= new StringBuilder();
        int len1= w1.length();
        int len2=w2.length();
        int i=0;
        while(i<len1 && i<len2){
            result.append(w1.charAt(i));
            result.append(w2.charAt(i));
            i++;
        }

        if(i<len1){
            result.append(w1.substring(i));
        }
        else{
            result.append(w2.substring(i));
        }
        return result.toString();
    }

    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        String w1= new String();
        String w2= new String();
        System.out.println("Enter first string: ");
        w1= sc.nextLine();
        System.out.println("Enter second string :");
        w2= sc.nextLine();
        MergeStringsAlternatively obj= new MergeStringsAlternatively();
        String result= obj.mergeAlternately(w1, w2);
        System.out.println("Merged String: "+ result);
    }
}
