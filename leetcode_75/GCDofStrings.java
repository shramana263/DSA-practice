import java.util.Scanner;

public class GCDofStrings {
    //time complexity: O(n+m)
    //space complexity: O(1)
    public boolean checkconcat(String s1, String s2){

        // System.out.println("s1+s2: "+ (s1+s2));
        // System.out.println("s2+s1: "+ (s2+s1));

        if(!(s1+s2).equals(s2+s1)){
            return false;
        }

        return true;
    }

    public int gcdOfLength(int a, int b){
        a=Math.abs(a);
        b=Math.abs(b);
        if(b==0){
            return a;
        }
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }

        return a;

    }

    public String gcdOfStrings(String str1, String str2) {
        // System.err.println("Inside GCD of Strings");
        String sb= new String();
        if(checkconcat(str1,str2)==false){
            // System.err.println("Strings do not have GCD");
            return "Strings do not have GCD";
        }

        int len1=str1.length();
        int len2=str2.length();
        // System.out.println("Length1: "+ len1 + " Length2: "+ len2);
        int resLen;
        if(len1<len2){
              
            resLen= gcdOfLength(len2,len1);
        }
        else{
            resLen= gcdOfLength(len1,len2);
        }

        sb= str1.substring(0,resLen);
        

        return sb;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1= new String();
        String s2= new String();
        System.out.println("Enter the first string: ");
        s1= sc.nextLine();
        System.out.println("enter the second string:  ");
        s2= sc.nextLine();

        GCDofStrings obj= new GCDofStrings();
        String result= obj.gcdOfStrings(s1, s2);
        System.out.println("GCD of Strings: "+ result);
    }
}
