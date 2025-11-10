
import java.util.Stack;

public class MinOperation{
    public int minOperations(int[] nums) {
        Stack<Integer> stack= new Stack<>();
        int count =0;
        for(int num:nums){
            while(!stack.isEmpty() && stack.peek()>num){
                stack.pop();
            }
            if(stack.isEmpty() || stack.peek()<num){
                if(num!=0){
                    count++;
                }
                stack.push(num);
            }
        }
        return count;
    }
    public static void main(String[] args){
        int[] nums={0,2};
        MinOperation obj = new MinOperation();
        System.out.println(obj.minOperations(nums));
    }
}