public class LengthLast {

    public int lengthOfLastWord(String s) {
        if(s.length()==0){
            return 0;
        }
        if(s.length()==1){
            return Character.isWhitespace(s.charAt(0))? (int)0 : (int)1;
        }
        int i=s.length()-1;
        while(Character.isWhitespace(s.charAt(i))){
            System.out.println(s.charAt(i)+"  whitespace");
            i--;
        }
        int count=0;
        while(!Character.isWhitespace(s.charAt(i))){
            System.out.println(s.charAt(i)+"  notwhitespace");
            // if(i==0){
            //     return s.length();
            // }
            count=count+1;
            if(i==0){
                break;
            }
            System.out.println("count =  " +count);
            i--;
        }
        return count;
    }

    //another approach
    //public int lengthOfLastWord(String s) {
    //     if (s == null || s.length() == 0) {
    //         return 0;
    //     }

    //     int i = s.length() - 1;
        
    //     // 1. Skip all trailing whitespace
    //     while (i >= 0 && Character.isWhitespace(s.charAt(i))) {
    //         i--;
    //     }
        
    //     // If the string was all spaces, i will now be -1, return 0
    //     if (i < 0) {
    //         return 0;
    //     }

    //     int length = 0;

    //     // 2. Count the characters of the last word
    //     while (i >= 0 && !Character.isWhitespace(s.charAt(i))) {
    //         length++;
    //         i--;
    //     }

    //     return length;
    // }

    public static void main(String[] args){
        String s= " q";
        LengthLast obj= new LengthLast();
        int result= obj.lengthOfLastWord(s);

        System.out.println(result);

    }
}
