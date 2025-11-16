public class SubStrOneOpt {
    public int numSub(String s) {
        final int MOD = 1_000_000_007;
        
        long totalSubstrings = 0;
        
        long currentCount = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                
                currentCount++;
            } else {
                
                long blockContribution = (currentCount * (currentCount + 1)) / 2;
                totalSubstrings = (totalSubstrings + blockContribution) % MOD;
                currentCount = 0;
            }
        }
        
        if (currentCount > 0) {
            long blockContribution = (currentCount * (currentCount + 1)) / 2;
            totalSubstrings = (totalSubstrings + blockContribution) % MOD;
        }
        return (int) totalSubstrings;
    }

     public static void main(String[] args){
        String s="111111";
        SubStrOneOpt obj= new SubStrOneOpt();
        System.out.println(obj.numSub(s));
    }
}
