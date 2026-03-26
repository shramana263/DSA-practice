import java.util.*;
class Sim{
    private int id;
    private String cName, circle;
    private double balance, rps;

    public Sim(int id, String cName, double balance, double rps, String circle){
        this.id=id;
        this.cName=cName;
        this.balance=balance;
        this.rps=rps;
        this.circle=circle;
    }
    public int getId(){
        return id;
    }
    public String getCName(){
        return cName;
    }
    public double getBalance(){
        return balance;
    }
    public double getRps(){
        return rps;
    }
    public String getCircle(){
        return circle;
    }
    public void setCircle(String circle){
        this.circle=circle;
    }
}

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Sim[] s= new Sim[5];
        for(int i=0;i<5;i++){
            int a= sc.nextInt();sc.nextLine();
            String b = sc.nextLine();
            double c= sc.nextDouble();sc.nextLine();
            double d= sc.nextDouble();sc.nextLine();
            String e= sc.nextLine();

            s[i]= new Sim(a,b,c,d,e);
        }
        String c1= sc.nextLine();
        String c2= sc.nextLine();
        Sim[] obj= transferCustomerCircle(s,c1,c2);
        if(obj==null){
            System.out.println("404 not found");
        }
        else{
            for(int i=0;i<obj.length;i++){
                System.out.println(obj[i].getId()+" "+obj[i].getCName()+" "+obj[i].getCircle()+" "+obj[i].getRps());
            }
        }
    }

    public static Sim[] transferCustomerCircle(Sim[] s,String c1, String c2){
        Sim[] obj= new Sim[0];
        for(int i=0;i<s.length;i++){
            if(s[i].getCircle().equals(c1)){
                s[i].setCircle(c2);
                obj=Arrays.copyOf(obj,obj.length+1);
                obj[obj.length-1]=s[i];
            }
        }
        Sim temp;
        for(int i=0;i<obj.length-1;i++){
            if(obj[i+1].getRps()>obj[i].getRps()){
                temp=obj[i];
                obj[i]=obj[i+1];
                obj[i+1]=temp;
            }
        }
        return obj;
    }
}
