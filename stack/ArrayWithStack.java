import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ArrayWithStack {
    public List<String> buildArray(int[] target, int n) {
        Stack<Integer> stack= new Stack<>();
        List<String> list = new ArrayList<>();
        int targetLength= target.length-1;
        int compareIndex=0;
        for(int i=1;i<=n;i++){
            if(compareIndex>targetLength){
                // System.out.println("going out of loop");
                break;
            }
            // System.out.println(n);
            stack.push(i);
            list.add("Push");
            // System.out.println("Push= "+i);
            if(stack.peek()!=target[compareIndex]){
                // System.out.println("Pop= "+stack.peek());
                stack.pop();
                list.add("Pop");
            }
            else{

            compareIndex++;
            }
            // System.out.println("Stack= "+stack);
        }
        return list;
    }

    public static void main(String[] args){
        int[] target={1,3};
        int n=3;
        ArrayWithStack obj = new ArrayWithStack();
        System.out.println(obj.buildArray(target, n));
    }
}
