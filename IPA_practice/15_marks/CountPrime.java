/* Count number of prime digit in a Number 
 * Input : 254786135
 * Output : 5
*/
import java.util.Scanner;
public class CountPrime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str= sc.nextLine();
        int count=0;
        for(int i=0;i<str.length();i++){
            int p=Integer.parseInt(String.valueOf(str.charAt(i)));
            if(p==2 || isPrime(p)){
                count++;
            }
        }
        System.out.println(count);
        sc.close();
    }

    public static boolean isPrime(int p){
        if(p==1){
            return false;
        }
        for(int i=2;i<=p/2;i++){
            if(p%i==0){
                return false;
            }
        }
        return true;
    }
    
}
