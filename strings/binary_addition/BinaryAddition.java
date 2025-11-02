public class BinaryAddition {
    public String addBinary(String a, String b) {
    // No need for separate initial checks for a.length()==0 or b.length()==0
    
    int i = a.length() - 1;
    int j = b.length() - 1;
    int carry = 0;
    StringBuilder sb = new StringBuilder();

    while (i >= 0 || j >= 0 || carry == 1) {
        // 1. Get the current digits (as int) or 0 if pointer is out of bounds
        int digitA = (i >= 0) ? a.charAt(i--) - '0' : 0;
        int digitB = (j >= 0) ? b.charAt(j--) - '0' : 0;

        // 2. Calculate the total sum for the current position
        int total = digitA + digitB + carry;

        // 3. The current result bit is the sum modulo 2 (e.g., 0%2=0, 1%2=1, 2%2=0, 3%2=1)
        sb.append(total % 2);

        // 4. The new carry is the sum divided by 2 (e.g., 0/2=0, 1/2=0, 2/2=1, 3/2=1)
        carry = total / 2;
    }

    return sb.reverse().toString();
}
    public static void main(String[] args){
        String a="10101";
        String b="1110011";
        BinaryAddition obj= new BinaryAddition();
        String result= obj.addBinary(a, b);
        System.out.println(result);
    }
}
