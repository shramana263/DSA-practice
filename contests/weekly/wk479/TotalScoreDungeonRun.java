import java.util.Arrays;

public class TotalScoreDungeonRun {
    public long totalScore(int hp, int[] damage, int[] requirement) {
                
        int n = damage.length;
        long totalScore = 0;

        long[] prefixSumDamage = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSumDamage[i + 1] = prefixSumDamage[i] + damage[i];
        }
        
        for (int i = 1; i <= n; i++) {
            long targetValue = (long)requirement[i-1] + prefixSumDamage[i] - hp;

            int foundIndex = Arrays.binarySearch(prefixSumDamage, 0, i, targetValue);

            int startIndex;
            if (foundIndex >= 0) {
                startIndex = foundIndex;
            } else {
                startIndex = -foundIndex - 1;
            }

            if (startIndex < i) {
                int pointsForRoomI = i - startIndex;
                totalScore += pointsForRoomI;
            }
        }
        
        return totalScore;
    }
}
