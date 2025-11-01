import java.util.ArrayList;
import java.util.List;

public class NumberRange {

    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return list;
        }

        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            
            if (j + 1 == nums.length || nums[j + 1] != nums[j] + 1) {
                
                if (i == j) {
                    list.add(String.valueOf(nums[i]));
                } 
                else {
                    list.add(nums[i] + "->" + nums[j]);
                }
                
                i = j + 1;
            }
        }

        return list;
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 2, 4, 5, 7};
        NumberRange obj = new NumberRange();
        List<String> str = obj.summaryRanges(a);
        System.out.println(str); // Output: [0->2, 4->5, 7]
    }
}