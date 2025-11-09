import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        // Stack to store counts (integers)
        Stack<Integer> countStack = new Stack<>();
        // Stack to store the strings/prefix built so far
        Stack<StringBuilder> resultStack = new Stack<>();
        
        // sb is now only used to build the current result string
        StringBuilder currentResult = new StringBuilder(); 
        int k = 0; // To build the repetition count
        
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // Handle multi-digit numbers (e.g., 10, 100)
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                // 1. Push the number 'k' onto the count stack
                countStack.push(k);
                
                // 2. Push the currently built string (prefix) onto the result stack
                resultStack.push(currentResult);
                
                // 3. Reset for the inner decoded string
                k = 0;
                currentResult = new StringBuilder();
            } else if (c == ']') {
                // 1. Pop the count and the previous prefix
                int repeatTimes = countStack.pop();
                StringBuilder previousResult = resultStack.pop();
                
                // 2. Build the repeated string
                StringBuilder temp = new StringBuilder();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(currentResult);
                }
                
                // 3. Append the repeated string (temp) to the previous result
                // The combined string becomes the new currentResult for the outer scope
                currentResult = previousResult.append(temp);
                
            } else {
                // Regular character: append it to the current result builder
                currentResult.append(c);
            }
        }
        
        return currentResult.toString();
    }

    public static void main(String[] args){
        String s = "3[a2[c]]";
        DecodeString obj = new DecodeString();
        // Expected output: "accaccacc"
        System.out.println("Input: " + s);
        System.out.println("Output: " + obj.decodeString(s));
    }
}