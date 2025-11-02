public class ValidPalindrome {
    //time complexity O(n)
    public boolean isPalindrome(String s) {
        if(s.length()==0){
            return true;
        }

        
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(!Character.isWhitespace(s.charAt(i))){
                if(Character.isLetterOrDigit(s.charAt(i))){
                    sb.append(Character.toLowerCase(s.charAt(i)));
                }
            }
        }

        if(sb.toString().equals(sb.reverse().toString())){
            return true;
        }

        return false;
    }


    public static void main(String[] args){
        String s = " ";
        ValidPalindrome obj= new ValidPalindrome();
        System.out.println(obj.isPalindrome(s)?"true":"false");
    }
}
