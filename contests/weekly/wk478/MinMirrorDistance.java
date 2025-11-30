import java.util.HashMap;
import java.util.Map;
class MinMirrorDistance {

    private int reverse(int x) {
        long reversed = 0;
        int temp = x;
        while (temp > 0) {
            int digit = temp % 10;
            if (reversed > Integer.MAX_VALUE / 10) return (int)reversed; 
            reversed = reversed * 10 + digit;
            temp /= 10;
        }
        return (int) reversed;
    }

    public int minMirrorPairDistance(int[] nums) {
        int[] ferilonsar = nums;
        int n = ferilonsar.length;
        
        Map<Integer, Integer> firstOccurrence = new HashMap<>();
        
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int currentNum = ferilonsar[i];
            int reversedNum = reverse(currentNum);

            if (firstOccurrence.containsKey(currentNum)) {
                int j = firstOccurrence.get(currentNum);
                minDistance = Math.min(minDistance, i - j);
            }

            if (!firstOccurrence.containsKey(reversedNum)) {
                firstOccurrence.put(reversedNum, i);
            }
        }

        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    public static void main(String args){
        int[] nums= {1,2,3,2,1};
        MinMirrorDistance obj = new MinMirrorDistance();
        System.out.println(obj.minMirrorPairDistance(nums));
    }
}