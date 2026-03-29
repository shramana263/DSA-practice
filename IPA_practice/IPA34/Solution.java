import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
class Player{
    private int id, matches, score;
    private String name, country;

    public Player(int id, String name , String country, int matches, int score){
        this.id=id;
        this.name=name;
        this.country=country;
        this.matches= matches;
        this.score=score;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getCountry(){
        return country;
    }
    public int getMatches(){
        return matches;
    }
    public int getScore(){
        return score;
    }
}

public class Solution {
    
    public static void main(String[] args){
        Scanner sc =   new Scanner(System.in);
        int size= sc.nextInt();sc.nextLine();
        Player[] pl= new Player[size];
        for(int i=0;i<size;i++){
            int a= sc.nextInt();sc.nextLine();
            String b= sc.nextLine();
            String e=sc.nextLine();
            int c= sc.nextInt(); sc.nextLine();
            int d= sc.nextInt();sc.nextLine();

            pl[i]= new Player(a,b,e,c,d);
        }
        String country= sc.nextLine();
        int score= sc.nextInt();sc.nextLine();
        Player[] obj= findPlayerName(pl, country, score);
        if(obj==null){
            System.out.println("404 not found");
        }
        else{
            for(Player o:obj){
                System.out.println(o.getId()+":"+o.getName());
            }
        }
        sc.close();
    }
    public static Player[] findPlayerName(Player[] player,String country, int score){
        Player[] obj= new Player[0];
        for(Player p:player){
            if(p.getCountry().equalsIgnoreCase(country) && p.getScore()>score){
                obj= Arrays.copyOf(obj,obj.length+1);
                obj[obj.length-1]=p;
            }
        }
        if(obj.length<1){
            return null;
        }
        Arrays.sort(obj,Comparator.comparing(Player::getName));
        return obj;
    }
}
