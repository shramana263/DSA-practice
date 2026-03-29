import java.util.Scanner;
class News{
    private int reg, year, price;
    private String name;

    public News(int reg, String name, int year, int price){
        this.reg= reg; 
        this.name= name;
        this.year= year;
        this.price=price;
    }
    public int getReg(){
        return reg;
    }
    public String getName(){
        return name;
    }
    public int getYear(){
        return year;
    }
    public int getPrice(){
        return price;
    }
}

public class Solution {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        News[] nw= new News[4];
        for(int i=0;i<4;i++){
            int a= sc.nextInt();sc.nextLine();
            String b= sc.nextLine();
            int c= sc.nextInt();sc.nextLine();
            int d= sc.nextInt();sc.nextLine();

            nw[i]= new News(a,b,c,d);

        }
        int year= sc.nextInt();sc.nextLine();
        String name= sc.nextLine();
        int ans= findTotalPriceByPublicationYear(nw,year);
        System.out.println(ans==0?"404 not found":ans);

        News n= searchNewspaperByName(nw,name);
        System.out.println(n==null?"404 not found": n.getReg()+" "+n.getName()+" "+n.getYear()+" "+n.getPrice());
    }

    public static int findTotalPriceByPublicationYear(News[] news, int year){
        int sum=0;
        for(News n:news){
            if(n.getYear()==year){
                sum+=n.getPrice();
            }
        }
        return sum;
    }

    public static News searchNewspaperByName(News[] news, String name){
        for(News n:news){
            if(n.getName().equalsIgnoreCase(name)){
                return n;
            }
        }
        return null;
    }
}
