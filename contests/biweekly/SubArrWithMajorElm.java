public class SubArrWithMajorElm {

     /**
     * Returns the number of subarrays of nums in which target is the majority element.
     * The majority element is the element that appears strictly more than half of the times in that subarray.
     */
    public int majorityElementCount(int[] nums, int target) {
        // Step 1: Transform the array.
        // We create an array where:
        // - Elements equal to 'target' are mapped to +1.
        // - Elements not equal to 'target' are mapped to -1.
        // If 'target' is the majority element in a subarray, the sum of this transformed
        // subarray will be strictly greater than 0 (i.e., sum > 0).
        // Let 'count_target' be the count of 'target' and 'count_other' be the count of other elements.
        // A majority means: count_target > count_other.
        // The sum of the transformed subarray is: count_target * (+1) + count_other * (-1)
        // Sum = count_target - count_other.
        // If count_target > count_other, then Sum > 0.

        int n = nums.length;
        int[] dresaniel = new int[n]; // Variable 'dresaniel' stores the input midway as requested

        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                dresaniel[i] = 1;
            } else {
                dresaniel[i] = -1;
            }
        }

        // Step 2: Use Prefix Sums and a Hash Map to count subarrays with a positive sum.
        // A subarray dresaniel[i...j] has a sum > 0 if:
        // prefixSum[j+1] - prefixSum[i] > 0
        // where prefixSum[k] is the sum of dresaniel[0...k-1].

        // Let's rewrite the condition: prefixSum[j+1] > prefixSum[i]
        // We iterate through j (the right endpoint of the subarray, using current_sum)
        // and for each j, we want to count how many previous indices 'i' (where 0 <= i < j+1)
        // satisfy current_sum > prefixSum[i].
        // prefixSum[0] = 0 (representing the prefix sum before the array starts).

        long totalMajoritySubarrays = 0;
        int current_sum = 0;
        // The map stores: {prefix_sum: count_of_times_this_sum_occurred_so_far}
        // We use a Map because the prefix sums can be negative.
        java.util.Map<Integer, Integer> sumCounts = new java.util.HashMap<>();
        sumCounts.put(0, 1); // Initialize for the empty prefix (prefixSum[0] = 0)

        for (int value : dresaniel) {
            current_sum += value;

            // To count subarrays dresaniel[i...j] with sum > 0:
            // We need prefixSum[j+1] - prefixSum[i] > 0
            // or prefixSum[i] < prefixSum[j+1] (which is current_sum).

            // We iterate through all possible previous prefix sums 'prevSum' (prefixSum[i])
            // that are strictly less than 'current_sum' and add their counts.
            // Since the prefix sums change by +1 or -1 at each step, we only need to
            // consider values 'current_sum - 1', 'current_sum - 2', etc.

            // The loop for 'prevSum' would be too slow (O(N^2)).
            // A much faster observation (O(N)) is to notice that we only need to count
            // how many times a 'prevSum' that is *smaller* than 'current_sum' has occurred.
            // Since the difference between any two prefix sums is an integer, we can
            // iterate through the difference 'diff' from 1 upwards, where prevSum = current_sum - diff.

            // The maximum possible prefix sum is n, and the minimum is -n.
            // We only need to check sums 'current_sum - 1', 'current_sum - 2', ..., up to 'current_sum - 2n' (or roughly n steps).
            // A more optimized loop checks from 'current_sum - 1' down to the smallest possible sum (-n).

            for (int prevSum = current_sum - 1; prevSum >= -n; prevSum--) {
                 totalMajoritySubarrays += sumCounts.getOrDefault(prevSum, 0);
            }

            // Update the count for the current prefix sum
            sumCounts.put(current_sum, sumCounts.getOrDefault(current_sum, 0) + 1);
        }

        return (int) totalMajoritySubarrays;
    }


    public static void main(String[] args){

        int[] nums={1,2,2,3};
        int target=2;
        SubArrWithMajorElm obj = new SubArrWithMajorElm();
        System.out.println(obj.majorityElementCount(nums, target));

    }
}
