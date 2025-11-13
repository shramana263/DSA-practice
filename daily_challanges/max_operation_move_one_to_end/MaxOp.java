public class MaxOp{

    public int maxOperations(String s) {
        int count=0;
        int n=s.length();
        int ans=0;
        int i=0;
        while(i<n){
            if(s.charAt(i)=='0'){
                while(i+1<n && s.charAt(i+1)=='0'){
                    i++;
                }
                ans+=count;
            }
            else{
                count++;

            }
            i++;
        }
        return ans;
    }

    public static void main(String[] args){
        String s= "000011";
        MaxOp obj = new MaxOp();
        System.out.println(obj.maxOperations(s));
    }
}