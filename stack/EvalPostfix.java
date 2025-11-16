import java.util.Stack;

public class EvalPostfix {
    public static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public int evalRPN(String[] tokens) {

        int n= tokens.length;
        if(n<1){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int a,b;
        for(int i=0;i<n;i++){
            if(isNumeric(tokens[i])){
                stack.push(Integer.parseInt(tokens[i]));
            }
            else{
                // a=stack.peek();
                // stack.pop();
                // System.out.println("Stack= "+stack);
                // b=stack.peek();
                // stack.pop();
                // System.out.println("Stack= "+stack);
                if(tokens[i].equals("+")){
                    a=stack.peek();
                    stack.pop();
                    // System.out.println("Stack= "+stack);
                    b=stack.peek();
                    stack.pop();
                    // System.out.println("Stack= "+stack);
                    stack.push(a+b);
                    // System.out.println("After Addition= "+stack);
                }
                else if(tokens[i].equals("-")){
                    a=stack.peek();
                    stack.pop();
                    // System.out.println("Stack= "+stack);
                    b=stack.peek();
                    stack.pop();
                    // System.out.println("Stack= "+stack);
                    stack.push(b-a);
                    // System.out.println("After Subtraction= "+stack);
                }
                else if(tokens[i].equals("*")){
                    a=stack.peek();
                    stack.pop();
                    // System.out.println("Stack= "+stack);
                    b=stack.peek();
                    stack.pop();
                    // System.out.println("Stack= "+stack);
                    stack.push(a*b);
                    // System.out.println("After Multiplication= "+stack);
                }
                else{
                    a=stack.peek();
                    if(a==0){
                        return 0;
                    }
                    stack.pop();
                    // System.out.println("Stack= "+stack);
                    b=stack.peek();
                    stack.pop();
                    // System.out.println("Stack= "+stack);
                    stack.push((int)b/a);
                    // System.out.println("After Division= "+stack);
                }
            }
            // System.out.println("Stack EOL= "+stack);
        }
        return stack.peek();
    }

    public static void main(String[] args){
        String[] nums={"2","1","+","3","*"};
        EvalPostfix obj = new EvalPostfix();
        System.out.println(obj.evalRPN(nums));
    }
}
