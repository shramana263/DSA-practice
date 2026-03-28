// aabbbcc = a2b3c2
// abbccc = a1b2c3

import java.util.Scanner;
public class CharRepeat {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String str= sc.nextLine();
        StringBuilder sb= new StringBuilder();
        char ch= str.charAt(0);
        int count=0;
        for(int i=0;i<str.length();i++){
            if(ch==str.charAt(i)){
                count++;
            }
            else{
                sb.append(ch);
                sb.append(count);
                count=0;
                ch=str.charAt(i);
                i--;
            }
        }
        sb.append(str.charAt(str.length()-1));
        sb.append(count);
        System.out.println(sb);
    }
}
