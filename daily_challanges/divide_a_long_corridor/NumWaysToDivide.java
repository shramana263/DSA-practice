public class NumWaysToDivide {

    public int numberOfWays(String corridor) {
        final int MOD = 1_000_000_007;
        int n = corridor.length();
        long totalWays = 1;
        
        int i = 0;
        while (i < n && corridor.charAt(i) == 'P') {
            i++;
        }
        
        if (i == n) {
            return 0; 
        }

        int seatCount;
        while (i < n) {
            seatCount = 0;
            int start_section = i;

            while (i < n && corridor.charAt(i) == 'P') { 
                i++; 
            }
            if (i < n) seatCount++;
            else break;
            i++; 
            while (i < n && corridor.charAt(i) == 'P') { 
                i++; 
            }
            if (i < n) seatCount++;
            else break; 
            int j = i + 1;
            while (j < n && corridor.charAt(j) == 'P') {
                j++;
            }
            if (j == n) {
                break;
            }
            
            long multiplier = (long)(j - i);

            totalWays = (totalWays * multiplier) % MOD;
            i = j;
        }

        int finalSeatCount = 0;
        for (char c : corridor.toCharArray()) {
            if (c == 'S') {
                finalSeatCount++;
            }
        }

        if (finalSeatCount % 2 != 0 || finalSeatCount == 0) {
            return 0;
        }

        return (int) totalWays;
    }


    public static void main(String[] args){
        String s="SSPPSPS";
        NumWaysToDivide obj = new NumWaysToDivide();
        System.out.println(obj.numberOfWays(s));
    }
}
