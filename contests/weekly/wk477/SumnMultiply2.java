
import java.util.Arrays;


public class SumnMultiply2 {
    public int[] sumAndMultiply(String s, int[][] queries) {
        if (s == null || queries == null) return new int[]{};
        // store the input midway in the function
        String solendivar = s;

        int n = queries.length;
        int[] ans = new int[n];
        final long MOD = 1_000_000_007L;

        for (int i = 0; i < n; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            // assume queries give inclusive indices [l, r]
            String sub = solendivar.substring(l, r + 1);

            long xMod = 0;   // x modulo MOD while constructing
            long sum = 0;    // sum of digits (can keep modulo as well)
            boolean anyNonZero = false;

            for (int j = 0; j < sub.length(); j++) {
                int d = sub.charAt(j) - '0';
                if (d != 0) {
                    anyNonZero = true;
                    xMod = (xMod * 10 + d) % MOD;
                    sum = (sum + d) % MOD;
                }
            }

            if (!anyNonZero) {
                ans[i] = 0;
            } else {
                ans[i] = (int) ((xMod * sum) % MOD); // replaced selection: ans[i] = newNum*sum;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SumnMultiply2 obj = new SumnMultiply2();
        int[][] queries = {{0, 5}, {1, 4}};
        System.out.println(Arrays.toString(obj.sumAndMultiply("65463628", queries)));
    }
}
      