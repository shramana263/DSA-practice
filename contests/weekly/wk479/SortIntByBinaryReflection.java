
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class SortIntByBinaryReflection {

    class NumberPair {
        int originalNum;
        int reflectionVal;

        NumberPair(int originalNum, int reflectionVal) {
            this.originalNum = originalNum;
            this.reflectionVal = reflectionVal;
        }
    }

    private int calculateReflection(int num) {
        String binaryString = Integer.toBinaryString(num);
        String reversedBinary = new StringBuilder(binaryString).reverse().toString();
        
        return Integer.parseInt(reversedBinary, 2);
    }

    public int[] sortByReflection(int[] nums) {
        List<NumberPair> pairs = new ArrayList<>();
        for (int num : nums) {
            int reflection = calculateReflection(num);
            pairs.add(new NumberPair(num, reflection));
        }
        Collections.sort(pairs, new Comparator<NumberPair>() {
            @Override
            public int compare(NumberPair a, NumberPair b) {
                if (a.reflectionVal != b.reflectionVal) {
                    return Integer.compare(a.reflectionVal, b.reflectionVal);
                } else {
                    return Integer.compare(a.originalNum, b.originalNum);
                }
            }
        });
        
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = pairs.get(i).originalNum;
        }

        return ans;
    }
}