
import java.util.Arrays;

public class RemoveDuplicates {
    //time complexity: O(nlogn)
    public int removeDuplicates(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return 1;
        }
        int i=0;
        while(i<nums.length){
            int a=nums[i];
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]!=a){
                    break;
                }
                nums[j]=Integer.MAX_VALUE;
            }
            i++;
        }
        Arrays.sort(nums);
        // for(int j=0;j<nums.length;j++){
        //     System.out.print(nums[j]+" ");
        // }
        return Arrays.stream(nums).filter(x->x!=Integer.MAX_VALUE).toArray().length;
        
    }
    public static void main(String[] args){
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int[] expectedNums = {0,1,2,3,4}; // The expected answer with correct length
        int k = new RemoveDuplicates().removeDuplicates(nums); // Calls your implementation
        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }
        System.out.println("All assertions passed.");
    }
}
