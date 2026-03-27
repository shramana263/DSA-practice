import java.util.Arrays;
import java.util.Scanner;
class Associate{
    private int id, exp;
    private String name, tech;

    public Associate(int id, String name, String tech, int exp){
        this.id=id;
        this.name=name;
        this.tech=tech;
        this.exp=exp;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getTech(){
        return tech;
    }
    public int getExp(){
        return exp;
    }
}

public class Solution {

    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        Associate[] as= new Associate[5];

        for(int i=0;i<5;i++){
            int a= sc.nextInt();sc.nextLine();
            String b= sc.nextLine();
            String c= sc.nextLine();
            int d= sc.nextInt();sc.nextLine();

            as[i]= new Associate(a,b,c,d);
        }
        String tech= sc.nextLine();
        Associate[] obj= associatesForGivenTechnology(as, tech);

        if(obj==null){
            System.out.println("404 not found");
        }
        else{
            for(Associate o:obj){
                System.out.println(o.getId());
            }
        }

        sc.close();

    }

    public static Associate[] associatesForGivenTechnology(Associate[] as, String tech){
        Associate[] obj= new Associate[0];
        for(Associate a:as){
            if(a.getTech().equalsIgnoreCase(tech) && a.getExp()%5==0){
                obj=Arrays.copyOf(obj,obj.length+1);
                obj[obj.length-1]=a;
            }
        }
        if(obj.length<1){
            return null;
        }
        return obj;
    }
}
