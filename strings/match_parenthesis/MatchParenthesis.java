
import java.util.Stack;

public class MatchParenthesis {

    public boolean isValid(String s) {
        if(s.length()==0||s.length()==1) return false;
        Stack<Character> sk= new Stack<>();

        for(char c:s.toCharArray()){
            if(c=='{'||c=='['||c=='('){
                sk.push(c);
            }
            else if(c=='}'||c==']'||c==')'){
                if(sk.isEmpty()){
                    return false;
                }
                char top= sk.peek();
                if(c=='}' && top!='{'|| c==']' && top!='[' || c==')' && top!='('){
                    return false;
                }
                sk.pop();
            }
        }

        return sk.isEmpty();
    }


    public static void main(String[] args){
        String s= "((";
        MatchParenthesis obj = new MatchParenthesis();
        System.out.println(obj.isValid(s)? "true" : "false");
    }
}
