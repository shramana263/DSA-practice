public class MedianofArrays {
    

// Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
// Example 1:

// Input: nums1 = [1,3], nums2 = [2]
// Output: 2.00000
// Explanation: merged array = [1,2,3] and median is 2.
// Example 2:

// Input: nums1 = [1,2], nums2 = [3,4]
// Output: 2.50000
// Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

    //time complexity: O(m+n)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1= nums1.length;
        int len2= nums2.length;
        int mergedLen= len1+len2;
        int[] merged= new int[mergedLen];
        int i=0,j=0,k=0;
        double median=0;
        while(i<len1 && j<len2){
            if(nums1[i]<nums2[j]){
                merged[k++]= nums1[i++];
            }
            else{
                merged[k++]=nums2[j++];
            }
        }
        while(i<len1){
            merged[k++]=nums1[i++];
        }
        while(j<len2){
            merged[k++]=nums2[j++];
        }

        if(mergedLen%2==0){
            median= (merged[(mergedLen/2)-1]+ merged[mergedLen/2])/2.0;
            return median;
        }
        median= merged[mergedLen/2];
        return median;
        
    }

    public static void main(String[] args){
        int[] a={1,3};
        int[] b={2,4};
        MedianofArrays obj= new MedianofArrays();
        double result= obj.findMedianSortedArrays(a, b);
        System.out.println("Median is: "+ result);
    }
 
}
