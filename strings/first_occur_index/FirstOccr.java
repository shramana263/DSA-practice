
public class FirstOccr {

    public int strStr(String haystack, String needle) {
    
        if (needle.length() == 0) {
            return 0; 
        }
        if (haystack.length() < needle.length()) {
            return -1; 
        }
        int n= haystack.length();
        int m= needle.length();

        for(int i=0;i<n-m+1;i++){
            String curr= haystack.substring(i,i+m);
            if(curr.equals(needle)){
                return i;
            }
        }
        
        return -1;
    }


    public static void main(String[] args){
        String haystack="sadbutsad";
        String needle="but";
        FirstOccr obj = new FirstOccr();
        int result = obj.strStr(haystack, needle);
        System.out.println(result);

    }
}
