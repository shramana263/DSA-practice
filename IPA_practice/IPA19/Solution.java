import java.util.Arrays;
import java.util.Scanner;
class Flowers{
    private int id, price, rating;
    private String name, type;

    public Flowers(int id, String name, int price, int rating, String type){
        this.id=id;
        this.name=name;
        this.price=price;
        this.rating=rating;
        this.type=type;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getPrice(){
        return price;
    }
    public int getRating(){
        return rating;
    }
    public String getType(){
        return type;
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Flowers[] f= new Flowers[4];
        for(int i=0;i<4;i++){
            int a= sc.nextInt();sc.nextLine();
            String b = sc.nextLine();
            int c= sc.nextInt();sc.nextLine();
            int d = sc.nextInt();sc.nextLine();
            String e= sc.nextLine();

            f[i]= new Flowers(a,b,c,d,e);
        }
        String type= sc.nextLine();
        Flowers obj= findMinPriceByType(f,type);

        System.out.println(obj==null?"404 not found":obj.getId());
    }

    public static Flowers findMinPriceByType(Flowers[] flow, String type){
        Flowers[] obj= new Flowers[0];
        for(Flowers f:flow){
            if(f.getType().equalsIgnoreCase(type) && f.getRating()>3){
                obj=Arrays.copyOf(obj,obj.length+1);
                obj[obj.length-1]=f;
            }
        }
        if(obj.length<1){
            return null;
        }
        Flowers temp;
        for(int i=0;i<obj.length-1;i++){
            if(obj[i+1].getPrice()>obj[i].getPrice()){
                temp=obj[i];
                obj[i]=obj[i+1];
                obj[i+1]=temp;
            }
        }
        return obj[obj.length-1];
    }
}
