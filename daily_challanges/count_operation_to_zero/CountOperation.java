

public class CountOperation {

    public int countOperations(int num1, int num2){
        
        int count=0;

        while(num1!=0 || num2!=0){
            if(num1==0 || num2==0){
                break;
            }
            if(num1>=num2){
                num1-=num2;
            }
            else{
                num2-=num1;
            }
            count++;
            System.out.println("num1= "+num1+"  num2= "+num2);
        }
        return count;
    }

    public static void main(String[] args){
        int num1=0;
        int num2=1;
        CountOperation obj= new CountOperation();
        System.out.println(obj.countOperations(num1, num2));
    }
}
