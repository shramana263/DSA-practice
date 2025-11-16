public class SubStrOne {
    public int numSub(String s) {
        int n= s.length();
        int count=0;
        int ans=0;
        int flag=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<=n;j++){
                String sub= s.substring(i, j);
                for(int k=0;k<sub.length();k++){
                    if(sub.charAt(k)=='0'){
                        flag=1;
                        break;
                    }
                }
                if(flag==0){
                    count++;
                }
            }
            // ans=count;
            // count=0;
            flag=0;
        }
        return count % 1000000007;
    }

    public static void main(String[] args){
        String s="111111";
        SubStrOne obj= new SubStrOne();
        System.out.println(obj.numSub(s));
    }
}
