/*Write a Java program to check if a given number is an Armstrong number or not.

Here's an example of the expected input and output:

Input number: 153
Output: "Yes, the number is an Armstrong number."

*/
import java.util.Scanner;
public class ArmStrong {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();sc.nextLine();
        int p=n;
        int power=0;
        while(p!=0){
            power ++;
            p=p/10;
        }
        System.out.println(power);
        p=n;
        int ans=0;
        while(p!=0){
            ans+=Math.pow(p%10,power);
            p/=10;
        }

        System.out.println(ans==n?"true":"false");

    }
}
