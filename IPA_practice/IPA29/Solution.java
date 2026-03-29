import java.util.Scanner;
class Account{
    private int id;
    private double balance, ir;

    public Account(int id, double balance, double ir){
        this.id=id;
        this.balance= balance;
        this.ir=ir;
    }
    public int getId(){
        return id;
    }
    public double getBal(){
        return balance;
    }
    public double getIr(){
        return id;
    }
}

public class Solution {

    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int a= sc.nextInt();sc.nextLine();
        double b= sc.nextDouble();sc.nextLine();
        double c= sc.nextDouble();sc.nextLine();

        Account ac= new Account(a,b,c);

        int n= sc.nextInt();sc.nextLine();

        double ans= totalInterest(ac,n);
        System.out.format("%.3f",ans);
        sc.close();
    }
    public static double totalInterest(Account ac, int time){
        double percentage= ac.getIr()*100/time;
        percentage+=ac.getIr();
        return percentage;
    }
}
