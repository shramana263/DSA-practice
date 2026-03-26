import java.util.*;
class Footware{
    private int fId,price;
    private String fName, fType;

    public Footware(int fId, String fName, String fType, int price){
        this.fId=fId;
        this.fName=fName;
        this.fType=fType;
        this.price=price;
    }

    public int getFId(){
        return fId;
    }
    public void setFId(int fId){
        this.fId=fId;
    }
    public String getFName(){
        return fName;
    }
    public void setFName(String fName){
        this.fName=fName;
    }
    public String getFType(){
        return fType;
    }
    public void setFType(String fType){
        this.fType=fType;
    }
    public int getPrice(){
        return price;
    }
    public void setPrice(int price){
        this.price=price;
    }
}
public class FootwareProgram{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Footware[] fw= new Footware[5];

        for(int i=0;i<5;i++){
            int a= sc.nextInt();sc.nextLine();
            String b= sc.nextLine();
            String c= sc.nextLine();
            int d= sc.nextInt();sc.nextLine();

            fw[i]= new Footware(a,b,c,d);
        }
        String fType= sc.nextLine();
        String ipFname= sc.nextLine();

        System.out.println(getCountByType(fw, fType)==0?"Footware not available":getCountByType(fw, fType));
        Footware ft= getSecondHighestPriceByBrand(fw,ipFname);
        if(ft==null){
            System.out.println("Brand not available");
        }
        else{
            System.out.println(ft.getPrice());
        }
    }

    //static method 1---
    public static int getCountByType(Footware[] fw, String fType){
        int count=0;
        for(int i=0;i<fw.length;i++){
            if(fw[i].getFType().equalsIgnoreCase(fType)){
                count++;
            }
        }
        if(count>0){
            return count;
        }
        else{
            return 0;
        }
    }

    //static method 2------
    public static Footware getSecondHighestPriceByBrand(Footware[] fw, String ipFname){
        Footware[] obj = new Footware[0];
        for(int i=0;i<fw.length;i++){
            if(fw[i].getFName().equals(ipFname)){
                obj=Arrays.copyOf(obj,obj.length+1);
                obj[obj.length-1]=fw[i];
            }
        }
        if(obj.length<2){
            return null;
        }
        else{
            Footware temp;
            for(int i=0;i<obj.length-1;i++){
                if(obj[i+1].getPrice()<obj[i].getPrice()){
                    temp=obj[i];
                    obj[i]=obj[i+1];
                    obj[i+1]=temp;
                }
            }
            return obj[obj.length-2];
        }
    }
}

