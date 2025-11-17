
import java.util.Stack;

public class DailyTemperature {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new java.util.Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prev_index = stack.pop();
                
                ans[prev_index] = i - prev_index;
            }
            
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args){
        int[] nums={73,74,75,71,69,72,76,73};
        DailyTemperature obj = new DailyTemperature();
        int[] result = obj.dailyTemperatures(nums);
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]+" ");
        }
    }
}
