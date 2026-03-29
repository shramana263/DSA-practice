import java.util.Scanner;
class TravelAgencies{
    private int regn,price;
    private String name, type;
    private boolean facility;

    public TravelAgencies(int regn, String name, String type, int price, boolean facility){
        this.regn=regn;
        this.name=name;
        this.type=type;
        this.price=price;
        this.facility=facility;
    }
    public int getRegn(){
        return regn;
    }
    public String getName(){
        return name;
    }
    public String getType(){
        return type;
    }
    public int getPrice(){
        return price;
    }
    public boolean getFacility(){
        return facility;
    }
}
public class Solution {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        TravelAgencies[] ta=new TravelAgencies[4];
        for(int i=0;i<4;i++){
            int a= sc.nextInt();sc.nextLine();
            String b= sc.nextLine();
            String c= sc.nextLine();
            int d= sc.nextInt();sc.nextLine();
            boolean e= sc.nextBoolean();sc.nextLine();
            
            ta[i]= new TravelAgencies(a,b,c,d,e);
        } 
        int regn= sc.nextInt();sc.nextLine();
        String type=sc.nextLine();

        int ans= findAgencyWithHighestPackagePrice(ta);
        System.out.println(ans==0?"404 not found":ans);

        TravelAgencies obj= agencyDetailsForGivenldAndType(ta,regn, type);
        if(obj==null){
            System.out.println("404 not found");
        }
        else{
            System.out.println(obj.getName()+":"+obj.getPrice());
        }
    }

    public static int findAgencyWithHighestPackagePrice(TravelAgencies[] ta){
        int max= ta[0].getPrice();
        for(int i=1;i<ta.length;i++){
            if(ta[i].getPrice()>max){
                max=ta[i].getPrice();
            }
        }
        return max;
    }

    public static TravelAgencies agencyDetailsForGivenldAndType(TravelAgencies[] ta, int regn, String type){
        for(TravelAgencies t:ta){
            if(t.getRegn()==regn && t.getType().equalsIgnoreCase(type) && t.getFacility()){
                return t;
            }
        }
        return null;
    }
}
