import java.util.Stack;

public class QueueUsingTwoStack {
    private Stack<Integer> instack = new Stack<>(); 
    private Stack<Integer> outstack = new Stack<>();
    public QueueUsingTwoStack() {
        // return null;
    }
    
    public void push(int x) {
        if(outstack.isEmpty()){
            instack.push(x);
        }
        else{
            while(!outstack.isEmpty()){
                instack.push(outstack.pop());
            }
            instack.push(x);
        }
        // return null;
    }
    
    public int pop() {
        if(!outstack.isEmpty()){
            return outstack.pop();
        }
        else{
            if(instack.isEmpty()){
                return 0;
            }
            while(!instack.isEmpty()){
                outstack.push(instack.pop());
            }
            return outstack.pop();
        }
    }
    
    public int peek() {
        if(!outstack.isEmpty()){
            return outstack.peek();
        }
        else{
            if(instack.isEmpty()){
                return 0;
            }
            while(!instack.isEmpty()){
                outstack.push(instack.pop());
            }
            return outstack.peek();
        }
    }
    
    public boolean empty() {
        if(outstack.isEmpty()){
            if(instack.isEmpty()){
                return true;
            }
            return false;
        }
        return false;
        
    }
}
