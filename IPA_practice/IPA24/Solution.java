import java.util.Arrays;
import java.util.Scanner;
class Inventory{
    private String id;
    private int max, curr, thres;

    public Inventory(String id, int max, int curr, int thres){
        this.id=id;
        this.max=max;
        this.curr=curr;
        this.thres=thres;
    }
    public String getId(){
        return id;
    }
    public int getMax(){
        return max;
    }
    public int getCurr(){
        return curr;
    }
    public int getThres(){
        return thres;
    }
}

public class Solution {

    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        Inventory[] inv= new Inventory[4];
        for(int i=0;i<4;i++){
            String a= sc.nextLine();
            int b= sc.nextInt();sc.nextLine();
            int c= sc.nextInt();sc.nextLine();
            int d=sc.nextInt();sc.nextLine();

            inv[i]= new Inventory(a,b,c,d);
        }
        int limit= sc.nextInt();sc.nextLine();
        Inventory[] obj= Replenish(inv,limit);
        for(Inventory o:obj){
            if(o.getThres()>75){
                System.out.println(o.getId()+" "+"Critical filling");
            }
            else if(o.getThres()<=75 && o.getThres()>50){
                System.out.println(o.getId()+" "+"Moderate filling");
            }
            else{
                System.out.println(o.getId()+" "+"non-critical filling");
            }
        }
    }

    public static Inventory[] Replenish(Inventory[] in, int limit){
        Inventory[] obj= new Inventory[0];
        for(Inventory i:in){
            if(i.getThres()<=limit){
                obj=Arrays.copyOf(obj,obj.length+1);
                obj[obj.length-1]=i;
            }
        }
        if(obj.length<1){
            return null;
        }
        return obj;
    }
}
