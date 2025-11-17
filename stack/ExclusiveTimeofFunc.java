import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class ExclusiveTimeofFunc {

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        int prev=0;

        for(String logEntry:logs){
            String[] logparts= logEntry.split(":");
            int funcId= Integer.parseInt(logparts[0]);
            String action=logparts[1];
            int curr= Integer.parseInt(logparts[2]);

            if(action.charAt(0)=='s'){
                if(!stack.isEmpty()){
                    int runningFunc = stack.peek();
                    result[runningFunc]+=curr-prev;
                }

                stack.push(funcId);
                prev=curr;
            }
            else{
                int endingFunc= stack.pop();
                result[endingFunc]+=curr-prev+1;

                prev=curr+1;
            }
        }
        return result;
    }

    public static void main(String[] args){
        List<String> logs = new ArrayList<>(Arrays.asList("0:start:0","1:start:2","1:end:5","0:end:6"));
        // System.out.println(logs);
        int n=2;
        ExclusiveTimeofFunc obj = new ExclusiveTimeofFunc();
        int[] result = obj.exclusiveTime(n, logs);

        for(int r:result){
            System.out.print(r + " ");
        }

    }
}
