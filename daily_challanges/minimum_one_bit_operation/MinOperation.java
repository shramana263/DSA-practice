public class MinOperation {
    public int minimumOneBitOperations(int n) {

        int result =0;
        while(n>0){
            result^=n;
            n>>=1;
        }


        return result;
    }

    public static void main(String[] args){
        int n=3;
        MinOperation obj= new MinOperation();
        System.out.println(obj.minimumOneBitOperations(n));
    }
}
