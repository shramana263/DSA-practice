
import java.util.Arrays;

public class MissingNumSortedArr {

    public int missingNumber(int[] nums) {
        // if(nums.length==0 || nums.length==1){
        //     return 1;
        // }
        Arrays.sort(nums);
        int n=nums.length;
        System.out.println("n= "+n);
        for(int i=0, j=0;i<=nums.length || j<=n;i++,j++){
            // System.out.println("i: "+nums[i]+"  j: "+j);
            if(i>nums.length-1){
                return n;
            }
            if(nums[i]!=j){
                return j;
            }
        }
        return 0;
    }

    //optimized approach
//     public int missingNumber(int[] nums) {
//     int n = nums.length;
    
//     // 1. Calculate the expected sum of all numbers from 0 to n
//     // Use long for the sum calculation to prevent potential integer overflow 
//     // if n is near the maximum value for an int (though typically n <= 10^4).
//     long expectedSum = (long)n * (n + 1) / 2;
    
//     // 2. Calculate the actual sum of all numbers in the array
//     long actualSum = 0;
//     for (int num : nums) {
//         actualSum += num;
//     }
    
//     // 3. The missing number is the difference
//     return (int)(expectedSum - actualSum);
// }
    
    public static void main(String[] args) {
        int[] nums= {1};
        MissingNumSortedArr obj= new MissingNumSortedArr();
        int result = obj.missingNumber(nums);
        System.out.println(result);
        
    }
}
