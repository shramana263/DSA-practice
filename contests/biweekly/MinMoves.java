import java.util.Arrays;

public class MinMoves {


    public int minMoves(int[] nums) {

        if(nums.length==0){
            return 0;
        }
        int n= nums.length;
        int sum=0;
        Arrays.sort(nums);

        for(int i=0;i<n;i++){
            sum+=nums[n-1]-nums[i];
        }

        return sum;

    }

    public static void main(String[] args){
        int[] nums= {4,4,5};
        MinMoves obj = new MinMoves();
        System.out.println(obj.minMoves(nums));
    }
}
