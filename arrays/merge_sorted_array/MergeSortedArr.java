

public class MergeSortedArr {
    //time complexity O(m+n) space complexity O(m+n)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0,j=0,k=0;
        int[] merged = new int[m+n];
        while(i<m && j<n){
            
                if(nums1[i]<nums2[j]){
                    merged[k] = nums1[i];
                    k++;
                    i++;
                } else {
                    merged[k] = nums2[j];
                    k++;
                    j++;
                }

        }
        while(i<m){
            
            merged[k]= nums1[i];
            k++;
            i++;
        }
        while(j<n){
            
            merged[k]= nums2[j];
            k++;
            j++;
        }
        for(int p=0;p<merged.length;p++){
            nums1[p] = merged[p];
        }
    }        

    public static void main(String[] args){
        int[] arr1 = {1,2,3,0,0,0};
        int[] arr2 = {2, 5, 6};
        MergeSortedArr obj = new MergeSortedArr();
        obj.merge(arr1, 3, arr2, 3);

    }
}
