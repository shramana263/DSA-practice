public class SearchInsertPosOpt {
    //time complexity: O(log n)
    public int searchInsert(int[] nums, int target) {
        // System.out.println("started");
        if(nums.length==0){
            // System.out.println("empty");
            return 0;
        }
        int low=0;
        int high=nums.length-1;

        if(target<=nums[low]){
            // System.out.println("there");
            return 0;
        }
        else if(target>nums[high]){
            // System.out.println("here");
            return nums.length;
        }
        else{
            // System.out.println("between");
            while(low < high){
                int mid= (low+high)/2;
                if(nums[mid]==target){
                    return mid;
                }
                else if(nums[mid]<target){
                    low=mid;
                }
                else{
                    high=mid;
                }
    
                if(low+1==high){
                    return high;
                }
    
            }
        }
        // System.out.println("end");
        return 0;

    }

    public static void main(String[] args){
        int[] nums= {2,7,8,9,10};
        int target = 9;
        SearchInsertPosOpt sip = new SearchInsertPosOpt();
        int result = sip.searchInsert(nums, target);
        System.out.println("The target " + target + " should be inserted at index: " + result);
    }
}
