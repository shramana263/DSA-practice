import java.util.Scanner;
class Team{
    private int id,run;
    private String name, country;

    public Team(int id, String name, String country, int run){
        this.id=id;
        this.name=name;
        this.country=country;
        this.run=run;

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
    public int getRun(){
        return run;
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size= sc.nextInt();sc.nextLine();
        Team[] t= new Team[size];
        for(int i=0;i<size;i++){
            int a= sc.nextInt();sc.nextLine();
            String b= sc.nextLine();
            String c= sc.nextLine();
            int d= sc.nextInt();sc.nextLine();

            t[i] = new Team(a,b,c,d);
        }
        int run= sc.nextInt();sc.nextLine();
        String country= sc.nextLine();
        Team obj= findPlayer(t,country, run);
        System.out.println(obj==null?"404 not found": obj.getId()+" "+obj.getName());
        sc.close();
    }

    public static Team findPlayer(Team[] team, String country,int run){
        for(Team t:team){
            if(t.getCountry().equalsIgnoreCase(country) && t.getRun()>run){
                return t;
            }
        }
        return null;
    }
    
}
