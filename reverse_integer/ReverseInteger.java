public class ReverseInteger {
    // Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

    // Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

    

    // Example 1:

    // Input: x = 123
    // Output: 321
    // Example 2:

    // Input: x = -123
    // Output: -321
    // Example 3:

    // Input: x = 120
    // Output: 21

    //time complexity: O(log10(n)) where n is the input integer
    //space complexity: O(1)
    public int reverse(int x) {

        long reversed = 0;
        while(x!=0){
            int digit = x % 10;
            x /= 10;

            // // Check for overflow/underflow before multiplying and adding
            // if(reversed > (Integer.MAX_VALUE - digit) /10){
            //     return 0; // Overflow
            // }
            // if(reversed < (Integer.MIN_VALUE - digit) /10){
            //     return 0; // Underflow
            // }

            reversed = reversed * 10 + digit;
        }
        if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) {
            return 0;
        }
        return (int)reversed;

    }


    public static void main(String[] args){
        int x=-123;
        
        ReverseInteger obj= new ReverseInteger();
        int result = obj.reverse(x);
        System.out.println(result);
    }
 
}
