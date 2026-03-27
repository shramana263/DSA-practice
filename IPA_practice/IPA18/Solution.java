import java.util.Arrays;
import java.util.Scanner;
class Antenna{
    private int id;
    private String name, pl;
    private double vswr;

    public Antenna(int id, String name, String pl, double vswr){
        this.id=id;
        this.name=name;
        this.pl=pl;
        this.vswr=vswr;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getPl(){
        return pl;
    }
    public double getVswr(){
        return vswr;
    }

}

public class Solution {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Antenna[] ant= new Antenna[4];

        for(int i=0;i<4;i++){
            int a= sc.nextInt();sc.nextLine();
            String b= sc.nextLine();
            String c= sc.nextLine();
            double d= sc.nextDouble();sc.nextLine();

            ant[i]= new Antenna(a,b,c,d);
        }
        String name= sc.nextLine();
        double vswr=sc.nextDouble();sc.nextLine();

        int ans=searchAntennaByName(ant,name);
        System.out.println(ans==0?"404 not found":ans);

        Antenna[] obj= sortAntennaByVSWR(ant,vswr);
        if(obj==null){
            System.out.println("404 not found");
        }
        else{
            for(Antenna o:obj){
                System.out.println(o.getPl());
            }
        }
    }

    public static int searchAntennaByName(Antenna[] ant, String name){
        for(Antenna a:ant){
            if(a.getName().equals(name)){
                return a.getId();
            }
        }
        return 0;
    }

    public static Antenna[] sortAntennaByVSWR(Antenna[] ant, double vswr){
        Antenna[] obj= new Antenna[0];
        for(Antenna a:ant){
            if(a.getVswr()<vswr){
                obj=Arrays.copyOf(obj,obj.length+1);
                obj[obj.length-1]=a;
            }
        }
        if(obj.length<1){
            return null;
        }
        Antenna temp;
        for(int i=0;i<obj.length-1;i++){
            if(obj[i].getVswr()>obj[i+1].getVswr()){
                temp=obj[i];
                obj[i]=obj[i+1];
                obj[i+1]=temp;
            }
        }
        return obj;
    }
}
