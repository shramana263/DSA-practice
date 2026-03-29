import java.util.Arrays;
import java.util.Scanner;
class Music{
    private int plnum,count;
    private String type;
    private double dur;

    public Music(int plnum, String type, int count, double dur){
        this.plnum=plnum;
        this.type=type;
        this.count=count;
        this.dur=dur;
    }
    public int getPlnum(){
        return plnum;
    }
    public String getType(){
        return type;
    }
    public int getCount(){
        return count;
    }
    public double getDur(){
        return dur;
    }
}

public class Solution {
    
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);   
        Music[] ms= new Music[4];
        for( int i=0;i<4;i++){
            int a= sc.nextInt();sc.nextLine();
            String b = sc.nextLine();
            int c= sc.nextInt();sc.nextLine();
            double d= sc.nextDouble();sc.nextLine();

            ms[i]= new Music(a,b,c,d);
        }
        int count= sc.nextInt();sc.nextLine();
        int dur= sc.nextInt();sc.nextLine();

        int ans= findAvgOfCount(ms,count);
        System.out.println(ans);

        Music[] obj= sortTypeByDuration(ms,dur);
        if(obj==null){
            System.out.println("404 not found");
        }
        else{
            for(Music m:obj){
                System.out.println(m.getType());
            }
        }
    }

    public static Music[] sortTypeByDuration(Music[] music, int dur){
        Music[] obj= new Music[0];
        for(Music m:music){
            if(m.getDur()>dur){
                obj=Arrays.copyOf(obj,obj.length+1);
                obj[obj.length-1]=m;
            }
        }
        if(obj.length<1){
            return null;
        }
        Music temp;
        for(int i=0;i<obj.length-1;i++){
            for(int j=i+1;j<obj.length;j++){
                if(obj[i].getDur()>obj[i+1].getDur()){
                    temp=obj[i];
                    obj[i]=obj[i+1];
                    obj[i+1]=temp;
                }
            }
        }
        return obj;
    }

    public static int findAvgOfCount(Music[] music, int count){
        int sum=0,cnt=0;
        for(Music m:music){
            if(m.getCount()>=count){
                sum+=m.getCount();
                cnt++;
            }
        }
        if(sum==0){
            return 0;
        }
        return sum/cnt;
    }
}
