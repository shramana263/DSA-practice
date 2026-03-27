import java.util.Arrays;
import java.util.Scanner;
class Fruits{
    private int id, price , rating;
    private String name;

    public Fruits(int id, String name, int price, int rating){
        this.id=id;
        this.name=name;
        this.price=price;
        this.rating=rating;
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
}

public class Solution {
    
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Fruits[] fr= new Fruits[4];
        for(int i=0;i<4;i++){
            int a = sc.nextInt();sc.nextLine();
            String b= sc.nextLine();
            int c= sc.nextInt();sc.nextLine();
            int d = sc.nextInt();sc.nextLine();

            fr[i]= new Fruits(a,b,c,d);
        }

        int rating= sc.nextInt();sc.nextLine();

        Fruits f= findMaximumPriceByRating(fr,rating);
        System.out.println(f==null?"404 not found": f.getId());
        sc.close();
    }

    public static Fruits findMaximumPriceByRating(Fruits[] fr, int rating){
        Fruits[] obj = new Fruits[0];
        for(Fruits f:fr){
            if(f.getRating()>rating){
                obj=Arrays.copyOf(obj,obj.length+1);
                obj[obj.length-1]=f;
            }
        }
        if(obj.length<1){
            return null;
        }
        Fruits temp;
        for(int i=0;i<obj.length-1;i++){
            if(obj[i+1].getPrice()<obj[i].getPrice()){
                temp= obj[i];
                obj[i]=obj[i+1];
                obj[i+1]=temp;
            }
        }
        return obj[obj.length-1];
    }
}
