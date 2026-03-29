// package IPA_practice.IPA26;
import java.util. Arrays;
import java.util.Scanner;
class Player{
    private int id, rank, matches, score;
    private String name;

    public Player(int id, String name, int rank, int matches, int score){
        this.id=id;
        this.name=name;
        this.rank=rank;
        this.matches=matches;
        this.score=score;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getRank(){
        return rank;
    }
    public int getMatches(){
        return matches;
    }
    public int getScore(){
        return score;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Player[] pl= new Player[4];
        for(int i=0;i<4;i++){
            int a = sc.nextInt();sc.nextLine();
            String b= sc.nextLine();
            int c= sc.nextInt();sc.nextLine();
            int d= sc.nextInt();sc.nextLine();
            int e= sc.nextInt();sc.nextLine();

            pl[i]= new Player(a,b,c,d,e);
        }
        int target=sc.nextInt();sc.nextLine();
        double[] obj= findAverageOfRuns(pl, target);
        for(double o:obj){
            if(o>=80 && o<=100){
                System.out.println("GRADE A");
            }
            else if(o>=50 && o<=79){
                System.out.println("GRADE B");
            }
            else{
                System.out.println("GRADE C");
            }
        }
        sc.close();

    }

    public static double[] findAverageOfRuns(Player[] pl, int target){
        double[] obj=new double[0];
        for(Player p :pl){
            if(target<=p.getMatches()){
                double avgRun= p.getScore()/p.getMatches();
                obj=Arrays.copyOf(obj,obj.length+1);
                obj[obj.length-1]=avgRun;
            }
        }
        if(obj.length<1){
            return null;
        }
        return obj;
    }
}
