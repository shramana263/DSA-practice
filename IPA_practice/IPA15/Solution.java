import java.util.Scanner;
class Phone{
    private int id, price;
    private String os, brand;

    public Phone(int id, String os, String brand, int price){
        this.id=id;
        this.os=os;
        this.brand=brand;
        this.price=price;
    }
    public int getId(){
        return id;
    }
    public String getOs(){
        return os;
    }
    public String getBrand(){
        return brand;
    }
    public int getPrice(){
        return price;
    }
}

public class Solution {

    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        Phone[] ph= new Phone[4];
        for(int i=0;i<4;i++){
            int a=sc.nextInt();sc.nextLine();
            String b= sc.nextLine();
            String c= sc.nextLine();
            int d= sc.nextInt();sc.nextLine();

            ph[i]= new Phone(a,b,c,d);
        }
        String brand= sc.nextLine();
        String os= sc.nextLine();

        int ans= findPriceForGivenBrand(ph,brand);
        System.out.println(ans==0?"404 not found":ans);

        Phone obj = getPhoneIdBasedOnOs(ph,os);
        System.out.println(obj==null?"404 not found":obj.getId());
    }

    public static int findPriceForGivenBrand(Phone[] ph, String brand){
        int sum=0;
        for(Phone p:ph){
            if(p.getBrand().equalsIgnoreCase(brand)){
                sum+=p.getPrice();
            }
        }
        return sum;
    }

    public static Phone getPhoneIdBasedOnOs(Phone[] ph, String os){
        if(ph.length<1){
            return null;
        }
        for(Phone p:ph){
            if(p.getOs().equalsIgnoreCase(os) && p.getPrice()>=50000){
                return p;
            }
        }
        return null;
    }
}
