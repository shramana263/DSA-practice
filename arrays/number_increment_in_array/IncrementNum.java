
import java.util.ArrayList;
public class IncrementNum {

    //this code is limited to handle only numbers within the range of integer data type

    //time complexity: O(n)
    public int[] plusOne(int[] digits) {
        ArrayList<Integer> result = new ArrayList<>();
        // int num=1;
        // for(int i=0;i<digits.length;i++){
        //     int num=num*()
        // }
        StringBuilder s = new StringBuilder();
        for(int i=0;i<digits.length;i++){
            s.append(digits[i]);
        }
        int num = Integer.parseInt(s.toString());
        num = num + 1;
        String incrementedNumStr = Integer.toString(num);
        for(int i=0;i<incrementedNumStr.length();i++){
            result.add(Character.getNumericValue(incrementedNumStr.charAt(i)));
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args){
        IncrementNum obj = new IncrementNum();
        int[] digits = {9,8,7,6,5,4,3,2,1,0};
        int[] result = obj.plusOne(digits);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i] + " ");
        }
    }

}
