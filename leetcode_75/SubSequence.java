public class SubSequence {
    public boolean isSubsequence(String s, String t) {
        int i=0;
        int n=t.length();
        int m=s.length();
        for(int j=0;j<n && i<m;j++){
            if(t.charAt(j) == s.charAt(i)){
                i++;
            }
        }
        return i == m;
    }

    public static void main(String[] args) {
        String main= "abcde";
        String sub= "";

        SubSequence obj= new SubSequence();
        System.out.println(obj.isSubsequence(sub, main)? "true":"false");
    }
}
