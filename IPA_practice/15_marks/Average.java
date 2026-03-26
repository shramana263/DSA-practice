/* Find average of a number array between two limit numbers (except the two numbers)
 * Input
 * ---------------
 *  5
    1 
    2
    3
    4
    5
    1
    4
 * 
 * Output
 * ---------------
 * 2
 */

import java.util.Scanner;
public class Average {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int[] arr= new int[8];
        for(int i=0;i<8;i++){
            arr[i]= sc.nextInt();sc.nextLine();
        }
        int sum=0;
        for(int i=1;i<arr.length-1;i++){
            sum+=arr[i];
        }
        int ans=sum/((arr.length)-2);
        System.out.println(ans);
    }
}
