
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestPrimeFromConsPrimeSum {
    private boolean[] findPrimesUpTo(int limit) {
        boolean[] isPrimeStatus = new boolean[limit + 1];
        Arrays.fill(isPrimeStatus, true);
        isPrimeStatus[0] = isPrimeStatus[1] = false;

        for (int p = 2; p * p <= limit; p++) {
            if (isPrimeStatus[p]) {
                for (int i = p * p; i <= limit; i += p) {
                    isPrimeStatus[i] = false;
                }
            }
        }
        return isPrimeStatus;
    }

    public int largestPrime(int n) {
        if (n < 2) {
            return 0;
        }

        boolean[] isPrimeMap = findPrimesUpTo(n);
        List<Integer> primesList = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrimeMap[i]) {
                primesList.add(i);
            }
        }

        int currentRunningSum = 0;
        int sum = 0;

        for (int prime : primesList) {
            currentRunningSum += prime;

            if (currentRunningSum <= n) {
                if (isPrimeMap[currentRunningSum]) { 
                    sum = currentRunningSum;
                }
            } else {
                break;
            }
        }

        return sum;
    }
}
