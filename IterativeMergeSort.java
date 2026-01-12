import java.util.Arrays;

public class IterativeMergeSort {

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;

        int n = arr.length;
        int[] temp = new int[n];

        // width: size of the subarrays to be merged (1, 2, 4, 8...)
        for (int width = 1; width < n; width *= 2) {
            
            // i: start index of the left subarray
            for (int i = 0; i < n; i += 2 * width) {
                
                int left = i;
                int mid = Math.min(i + width, n);
                int right = Math.min(i + 2 * width, n);

                // Merge the two halves into the temp array
                int lIdx = left;
                int rIdx = mid;

                for (int k = left; k < right; k++) {
                    if (lIdx < mid && (rIdx >= right || arr[lIdx] <= arr[rIdx])) {
                        temp[k] = arr[lIdx];
                        lIdx++;
                    } else {
                        temp[k] = arr[rIdx];
                        rIdx++;
                    }
                }
            }

            // Copy the merged chunks from temp back to the original array
            for (int i = 0; i < n; i++) {
                arr[i] = temp[i];
            }
        }
    }

    public static void main(String[] args) {
        int[] data = {12, 11, 13, 5, 6, 7};
        System.out.println("Original: " + Arrays.toString(data));
        
        mergeSort(data);
        
        System.out.println("Sorted:   " + Arrays.toString(data));
    }
}