import java.util.Scanner;
class Player{
    private int id, points;
    private String skill, level;

    public Player(int id, String skill, String level, int points){
        this.id=id;
        this.skill=skill;
        this.level=level;
        this.points=points;
    }
    public int getId(){
        return id;
    }
    public String getSkill(){
        return skill;
    }
    public String getLevel(){
        return level;
    }
    public int getPoints(){
        return points;
    }
}

public class Solution {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Player[] pl= new Player[4];
        for(int i=0;i<4;i++){
            int a = sc.nextInt();sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d= sc.nextInt();sc.nextLine();

            pl[i]= new Player(a,b,c,d);
        }

        String skill= sc.nextLine();
        String level= sc.nextLine();

        int ans1= findPointsForGivenSkill(pl,skill);
        System.out.println(ans1==0?"404 not found":ans1);

        Player ans2= getPlayerBasedOnLevel(pl,level,skill);
        System.out.println(ans2==null?"404 not found":ans2.getId());
    }

    public static int findPointsForGivenSkill(Player[] pl, String skill){
        int sum=0;
        if(pl==null){
            return 0;
        }
        for(int i=0;i<pl.length;i++){
            if(pl[i].getSkill().equalsIgnoreCase(skill)){
                sum+=pl[i].getPoints();
            }
        }
        return sum;
    }

    public static Player getPlayerBasedOnLevel(Player[] pl, String level, String skill){
        if(pl==null){
            return null;
        }
        for(int i=0;i<pl.length;i++){
            if(pl[i].getLevel().equalsIgnoreCase(level) && pl[i].getSkill().equalsIgnoreCase(skill) && pl[i].getPoints()>=20){
                return pl[i];
            }
        }
        return null;
    }
}
