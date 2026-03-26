import java.util.*;
class Motel{
    private int mid,numroom;
    private String mName,dob,cab;
    private double bill;

    public Motel(int mid, String mName, String dob, int numroom,String cab,double bill){
        this.mid=mid;
        this.mName=mName;
        this.dob=dob;
        this.numroom=numroom;
        this.cab=cab;
        this.bill=bill;
    }
    public int getMid(){
        return mid;
    }
    public String getMName(){
        return mName;
    }
    public String getDob(){
        return dob;
    }
    public int getNumroom(){
        return numroom;
    }
    public String getCab(){
        return cab;
    }
    public double getBill(){
        return bill;
    }

}

public class Solution {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Motel[] m = new Motel[4];
        for(int i=0;i<4;i++){
            int a= sc.nextInt();sc.nextLine();
            String b= sc.nextLine();
            String c= sc.nextLine();
            int d = sc.nextInt();sc.nextLine();
            String e= sc.nextLine();
            double f= sc.nextDouble();sc.nextLine();

            m[i]= new Motel(a,b,c,d,e,f);
        }
        String cab= sc.nextLine();

        System.out.println(totalNoOfRoomsBooked(m,cab)==0?"No such room booked": totalNoOfRoomsBooked(m,cab));
    }

    public static int totalNoOfRoomsBooked(Motel[] m, String cab){
        // int count=0;
        for(int i=0;i<m.length;i++){
            if(m[i].getCab().equals(cab) && m[i].getNumroom()>5){
                return m[i].getNumroom();
            }
        }
        return 0;
    }
}

