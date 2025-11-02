import java.util.Arrays;

public class StrDiff {

    public char findTheDifference(String s, String t) {

        char[] a= s.toCharArray();
        char[] b= t.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        for(int i=0;i<a.length;i++){
            if(a[i]!=b[i]){
                return b[i];
            }
        }
        return b[b.length-1];
    }

    public static void main(String[] args){
        String s="", t="u";
        StrDiff obj= new StrDiff();
        char res= obj.findTheDifference(s, t);
        System.out.println(res);
    }
    
}
