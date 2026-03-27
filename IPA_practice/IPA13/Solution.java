import java.util.*;
class AutonomousCar{
    private int id, notc,notp;
    private String brand,env,grade;

    public AutonomousCar(int id, String brand, int notc, int notp, String env){
        this.id=id;
        this.brand=brand;
        this.notc=notc;
        this.notp=notp;
        this.env=env;
    }
    public int getId(){
        return id;
    }
    public String getBrand(){
        return brand;
    }
    public int getNotc(){
        return notc;
    }
    public int getNotp(){
        return notp;
    }
    public String getEnv(){
        return env;
    }
    public String getGrade(){
        return grade;
    }
    public void setGrade(String grade){
        this.grade=grade;
    }
}

public class Solution{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        AutonomousCar[] ac= new AutonomousCar[4];

        for(int i=0;i<4;i++){
            int a= sc.nextInt();sc.nextLine();
            String b= sc.nextLine();
            int c= sc.nextInt();sc.nextLine();
            int d= sc.nextInt();sc.nextLine();
            String e= sc.nextLine();

            ac[i]= new AutonomousCar(a,b,c,d,e);
        }
        String env= sc.nextLine();
        String brand=sc.nextLine();

        int ans1= findTestPassedByEnv(ac,env);
        System.out.println(ans1==0?"404 not found":ans1);

        AutonomousCar[] obj = updateCarGrade(ac,brand);
        if(obj==null){
            System.out.println("404 not found");
        }
        else{
            for(AutonomousCar c:obj){
                System.out.println(c.getBrand()+"::"+c.getGrade());
            }
        }
    }

    public static int findTestPassedByEnv(AutonomousCar[] ac, String env){
        int count=0;
        for(int i=0;i<ac.length;i++){
            if(ac[i].getEnv().equals(env)){
                count+=ac[i].getNotp();
            }
        }
        return count;
    }

    public static AutonomousCar[] updateCarGrade(AutonomousCar[] ac, String brand){
        if(ac.length<1){
            return null;
        }
        AutonomousCar[] obj= new AutonomousCar[0];
        for(AutonomousCar car:ac){
            if(car.getBrand().equalsIgnoreCase(brand)){
                int rating = (car.getNotp()*100)/car.getNotc();
                car.setGrade(rating>=80?"A1":"B2");
                obj=Arrays.copyOf(obj,obj.length+1);
                obj[obj.length-1]=car;
            }
        }
        if(obj.length<1){
            return null;
        }
        return obj;
    }
}