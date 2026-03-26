import java.util.*;
class Hotel{
    private int id, numroom;
    private String name, dob, wifi;
    private double bill;

    public Hotel(int id, String name, String dob, int numroom, String wifi, double bill){
        this.id=id;
        this.name=name;
        this.dob=dob;
        this.numroom=numroom;
        this.wifi=wifi;
        this.bill=bill;

    }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getDob(){
        return dob;
    }
    public int getNumroom(){
        return numroom;
    }
    public String getWifi(){
        return wifi;
    }
    public double getBill(){
        return bill;
    }

}

public class Solution {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        Hotel[] h= new Hotel[4];
        for(int i=0;i<4;i++){
            int a= sc.nextInt();sc.nextLine();
            String b = sc.nextLine();
            String c= sc.nextLine();
            int d= sc.nextInt();sc.nextLine();
            String e= sc.nextLine();
            double f= sc.nextDouble(); sc.nextLine();

            h[i]= new Hotel(a,b,c,d,e,f);
        }

        String month = sc.nextLine();
        String wifi= sc.nextLine();

        System.out.println();
        System.out.println(noOfRoomsBookedInGivenMonth(h,month)==0?"No room booked this month":noOfRoomsBookedInGivenMonth(h,month));
        Hotel obj = searchHotelByWifiOption(h,wifi);
        System.out.println(obj==null?"no such option available":obj.getId());
    }

    public static int noOfRoomsBookedInGivenMonth(Hotel[] h, String month){
        int count=0;
        for(int i=0;i<h.length;i++){
            if(h[i].getDob().substring(3,6).equalsIgnoreCase(month)){
                count+=h[i].getNumroom();
            }
        }
        return count;
    }
    public static Hotel searchHotelByWifiOption(Hotel[] h, String wifi){
        Hotel[] obj = new Hotel[0];
        for(int i=0;i<h.length;i++){
            if(h[i].getWifi().equalsIgnoreCase(wifi)){
                obj=Arrays.copyOf(obj,obj.length+1);
                obj[obj.length-1]=h[i];
            }
        }
        if(obj.length<1){
            return null;
        }
        Hotel temp;
        for(int i=0;i<obj.length-1;i++){
            if(obj[i+1].getBill()>obj[i].getBill()){
                temp=obj[i];
                obj[i]=obj[i+1];
                obj[i+1]=temp;
            }
        }
        return obj[1];
    }
}
