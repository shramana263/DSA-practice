import java.util.Scanner;

class Mobile{
    private int id,price;
    private String brand;
    private boolean flag;

    public Mobile(int id, int price, String brand, boolean flag){
        this.id=id;
        this.price=price;
        this.brand=brand;
        this.flag=flag;
    }
    public int getId(){
        return id;
    }
    public int getPrice(){
        return price;
    }
    public String getBrand(){
        return brand;
    }
    public boolean getFlag(){
        return flag;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Mobile[] mob= new Mobile[5];
        for(int i=0;i<5;i++){
            int a= sc.nextInt();sc.nextLine();
            int b= sc.nextInt();sc.nextLine();
            String c= sc.nextLine();
            boolean d= sc.nextBoolean();sc.nextLine();

            mob[i]=new Mobile(a,b,c,d);
        }
        String brand= sc.nextLine();

        int ans=getTotalPrice(mob, brand);
        System.out.println(ans==0?"404 not found":ans);

        int ans1= getSecondMin(mob);
        System.out.println(ans1==0?"404 not found": mob[ans1].getBrand()+" "+mob[ans1].getPrice());
    }

    public static int getTotalPrice(Mobile[] mob, String brand){
        int sum=0;
        for(Mobile m:mob){
            if(m.getBrand().equals(brand)){
                sum+=m.getPrice();
            }
        }
        return sum;
    }

    public static int getSecondMin(Mobile[] mob){
        int highest=0;
        int secondHighest=0;
        for(int i=0;i<mob.length;i++){
            if(mob[i].getPrice()>mob[highest].getPrice()){
                secondHighest=highest;
                highest=i;
            }
        }
        return secondHighest;
    }
}
