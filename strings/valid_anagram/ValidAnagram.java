
import java.util.Arrays;


public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length()==0 && t.length()==0) return true;
        if(s.length()!=t.length()) return false;

        char[] a= s.toCharArray();
        char[] b= t.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        for(int i=0;i<a.length;i++){
            if(a[i]!=b[i]){
                return false;
            }
        }
        
        return true;
    }

    public static void main(String[] args){
        String s = "a", t = "ab";
        ValidAnagram obj = new ValidAnagram();
        System.out.println(obj.isAnagram(s, t)?"true":"false");
    }
}
