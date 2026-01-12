public class CompletePrime {
    public boolean completePrime(int num) {
        int flag=0;
        if(num==1){
            System.out.println("3");
            return false;
        }
        for(int i=3;i<=num/2;i++){
            if(num%i==0){
                System.out.println("1");
                return false;
            }
            
        }
        while(num!=0){
            if((num%10)%4==0 || num%10==1){
                System.out.println("2");
                return false;
            }
            int m=num/10;
            for(int i=3;i<=(m/2);i++){
                if(num%i==0){
                System.out.println("1");
                return false;
            }
            }

            num/=10;
        }
        return true;
    }
    public static void main(String[] args){
        int n= 257;
        CompletePrime obj = new CompletePrime();
        System.out.println(obj.completePrime(n)==true?"true":"false");
    }
}
