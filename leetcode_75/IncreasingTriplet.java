public class IncreasingTriplet {

    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= first) {
                first = num;
            } else if (num <= second) {
                second = num;
            } else {
                // num > second (and second > first implicitly)
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[] nums={100,2,0,43,50};
        IncreasingTriplet obj= new IncreasingTriplet();
        System.out.println(obj.increasingTriplet(nums)?"true":"false");
    }
}
