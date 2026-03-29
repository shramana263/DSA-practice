import java.util.Arrays;
import java.util.Scanner;
class Sim{
    private int id,balance;
    private String com,circle;
    private double rps;

    public Sim(int id, String com, int balance, double rps, String circle){
        this.id=id;
        this.com=com;
        this.balance=balance;
        this.rps=rps;
        this.circle=circle;
    }
    public int getId(){
        return id;
    }
    public String getCom(){
        return com;
    }
    public int getBalance(){
        return balance;
    }
    public double getRps(){
        return rps;
    }
    public String getCircle(){
        return circle;
    }
}

public class Solution {
    public static void main(String [] args){
        Scanner sc= new Scanner(System.in);
        Sim[] sm= new Sim[4];
        for(int i=0;i<4;i++){
            int a= sc.nextInt();sc.nextLine();
            String b= sc.nextLine();
            int c= sc.nextInt();sc.nextLine();
            double d= sc.nextDouble();sc.nextLine();
            String e= sc.nextLine();

            sm[i]= new Sim(a,b,c,d,e);
        }
        String circle= sc.nextLine();
        double rps=sc.nextDouble();sc.nextLine();
        Sim[] obj = matchAndSort(sm, circle, rps);
        if(obj==null){
            System.out.println("404 not found");
        }
        else{
            for(Sim o:obj){
                System.out.println(o.getId() +"::"+o.getBalance());
            }
        }
        sc.close();
    }

    public static Sim[] matchAndSort(Sim[] sim, String circle, double rps){
        Sim[] obj= new Sim[0];
        for(Sim s:sim){
            if(s.getCircle().equalsIgnoreCase(circle) && s.getRps()<=rps){
                obj=Arrays.copyOf(obj,obj.length+1);
                obj[obj.length-1]=s;
            }
        }
        Sim temp;
        for(int i=0; i<obj.length-1; i++) {
            for(int j=0; j<obj.length-1-i; j++) {
                if(obj[j].getBalance() < obj[j+1].getBalance()) {
                    temp = obj[j];
                    obj[j] = obj[j+1];
                    obj[j+1] = temp;
                }
            }
        }
        return obj;
    }
}
