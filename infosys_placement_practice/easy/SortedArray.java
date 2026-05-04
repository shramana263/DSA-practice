public class SortedArray {
    // Given an array arr[], check whether it is sorted in non-decreasing order. Return true if it is sorted otherwise false.

    public boolean isSorted(int[] arr) {
        // code here
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1]){
                return false;
            }
        }
        return true;
    }
}
