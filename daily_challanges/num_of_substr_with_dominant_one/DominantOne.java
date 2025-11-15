public class DominantOne {

    public int numberOfSubstrings(String s) {

        int count0=0;
        int count1=0;
        int ans=0;
        int n= s.length();
        // StringBuilder str= new StringBuilder();
        // List<String>
        if(n<1){
            return 0;
        }
        
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                
                for(char ch:s.substring(i,j).toCharArray()){
                    if(ch=='0'){
                        count0++;
                    }
                    else{
                        count1++;
                    }
                    
                }
                
                if(count1>=count0*2){
                    System.out.println("String= "+s.substring(i, j));
                    System.out.println("0s= "+count0+" 1s= "+count1);
                    ans++;
                }
                count0=0;
                count1=0;
            }            
        }

        return ans;
    }

    public static void main(String[] args){
        String s= "00011";
        DominantOne obj = new DominantOne();
        System.out.println(obj.numberOfSubstrings(s));
    }
}
