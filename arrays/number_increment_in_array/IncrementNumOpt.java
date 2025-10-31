public class IncrementNumOpt {

    public int[] plusOne(int[] digits){
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i]<9){
                digits[i]++;
                return digits;
            }
            digits[i]=0;
        }
        int[] newDigits= new int[digits.length+1];
        newDigits[0]=1;
        return newDigits;
    }

    public static void main(String[] args){
        IncrementNumOpt obj = new IncrementNumOpt();
        int[] digits = {9,8,7,6,5,4,3,2,1,0};
        int[] result = obj.plusOne(digits);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i] + " ");
        }
    }
}
