public class Multiply {
    public int findFinalValue(int[] nums, int original) {
        int n=nums.length;
        int i=0;
        while(i<n){
            if(nums[i]==original){
                original*=2;
                i=0;
            }
            else{

            i++;
            }
        }
        return original;
    }

    public static void main(String[] args){
        int[] nums= {5,3,6,1,12};
        int n=3;
        Multiply obj = new Multiply();
        System.out.println(obj.findFinalValue(nums, n));
    }
}
