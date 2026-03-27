import java.util.Arrays;
import java.util.Scanner;
class Engine{
    private int id;
    private String name, type;
    private double price;

    public Engine(int id, String name, String type, double price){
        this.id=id;
        this.name=name;
        this.type=type;
        this.price=price;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getType(){
        return type;
    }
    public double getPrice(){
        return price;
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        Engine[] eng= new Engine[4];
        for(int i=0;i<4;i++){
            int a = sc.nextInt();sc.nextLine();
            String b= sc.nextLine();
            String c = sc.nextLine();
            double d= sc.nextDouble();sc.nextLine();

            eng[i]= new Engine(a,b,c,d);

        }  
        String type= sc.nextLine();
        String name= sc.nextLine();

        double ans= findAvgEnginePriceByType(eng,type);
        System.out.println(ans<=0?"404 not found":ans);

        Engine[] obj= searchEngineByName(eng, name);
        if(obj==null){
            System.out.println("404 not found");
        }
        else{
            for(Engine o:obj){
                System.out.println(o.getId());
            }
        }
        sc.close();
    }

    public static double findAvgEnginePriceByType(Engine[] eng, String type){
        double sum=0;
        int count=0;
        for(Engine e:eng){
            if(e.getType().equalsIgnoreCase(type)){
                sum+=e.getPrice();
                count++;
            }
        }
        if(sum==0){
            return 0;
        }
        return sum/count;
    }

    public static Engine[] searchEngineByName(Engine[] eng, String name){
        Engine[] obj= new Engine[0];
        for(Engine e:eng){
            if(e.getName().equalsIgnoreCase(name)){
                obj=Arrays.copyOf(obj,obj.length+1);
                obj[obj.length-1]=e;
            }
        }
        if(obj.length<1){
            return null;
        }
        Engine temp;
        for(int i=0;i<obj.length-1;i++){
            if(obj[i+1].getId()<obj[i].getId()){
                temp=obj[i];
                obj[i]=obj[i+1];
                obj[i+1]=temp;
            }
        }
        return obj;
    }
}
