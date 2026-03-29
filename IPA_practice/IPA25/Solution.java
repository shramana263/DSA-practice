import java.util.Scanner;
class Cinema{
    private int id, rating, budget;
    private String dir;

    public Cinema(int id, String dir, int rating, int budget){
        this.id=id;
        this.dir=dir;
        this.rating=rating;
        this.budget=budget;
    }
    public int getId(){
        return id;
    }
    public String getDir(){
        return dir;
    }
    public int getRating(){
        return rating;
    }
    public int getBudget(){
        return budget;
    }
}

public class Solution {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        Cinema[] cin= new Cinema[4];
        for(int i=0;i<4;i++){
            int a = sc.nextInt();sc.nextLine();
            String b= sc.nextLine();
            int c = sc.nextInt();sc.nextLine();
            int d= sc.nextInt();sc.nextLine();

            cin[i]= new Cinema(a,b,c,d);
        }

        String dir = sc.nextLine();
        int rating= sc.nextInt();sc.nextLine();
        int budget= sc.nextInt();sc.nextLine();
        
        int ans = findAvgBudgetByDirector(cin,dir);
        System.out.println(ans==0?"404 not found":ans);
        Cinema c= getMovieByRatingBudget(cin, rating, budget);
        System.out.println(c==null?"404 not found":c.getId());
        sc.close();
    }

    public static int findAvgBudgetByDirector(Cinema[] cin, String dir){
        int sum=0;
        int count=0;
        for(Cinema c:cin){
            if(c.getDir().equalsIgnoreCase(dir)){
                sum+=c.getBudget();
                count++;
            }
        }
        if(sum==0){
            return 0;
        }
        return sum/count;
    }

    public static Cinema getMovieByRatingBudget(Cinema[] cin, int rating, int budget){
        for(Cinema c:cin){
            if(c.getRating()==rating && c.getBudget()==budget && c.getBudget()%c.getRating()==0){
                return c;
            }
        }
        return null;
    }
}
