import java.util.Scanner;
public class PalindromeNum {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int original=x;
        int reversed=0;
        while(x!=0){
            int digit=x%10;
            reversed=reversed*10+digit;
            x=x/10;
        }
        if(reversed!=original) return false;
        return true;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int i= sc.nextInt();

        PalindromeNum obj= new PalindromeNum();
        System.out.println(obj.isPalindrome(i));
        
    }
}
