public class StrDiffXOR {

    public char findTheDifference(String s, String t){
        char diff=0;

        for(char i:t.toCharArray()){
            diff^=i;
        }

        for(char i:s.toCharArray()){
            diff^=i;
        }

        return diff;

    }

    public static void main(String[] args){
        String s="", t="u";
        StrDiffXOR obj= new StrDiffXOR();
        char res= obj.findTheDifference(s, t);
        System.out.println(res);
    }
}
