import java.util.*;
class College{
    private int id, contact, pin;
    private String name, addr;

    public College(int id, String name, int contact, String addr, int pin){
        this.id=id;
        this.name=name;
        this.contact= contact;
        this.addr=addr;
        this.pin= pin;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public int getContact(){
        return contact;
    }
    public void setContact(int contact){
        this.contact=contact;
    }
    public int getPin(){
        return pin;
    }
    public void setPin(int pin){
        this.pin=pin;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getAddr(){
        return addr;
    }
    public void setAddr(String addr){
        this.addr=addr;
    }
}

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int size= sc.nextInt();sc.nextLine();
        College[] clg = new College[size];

        for(int i=0;i<size;i++){
            int a = sc.nextInt();sc.nextLine();
            String b= sc.nextLine();
            int c= sc.nextInt();sc.nextLine();
            String d= sc.nextLine();
            int e= sc.nextInt();sc.nextLine();

            clg[i]= new College(a,b,c,d,e);
        }

        String addr= sc.nextLine();

        College obj1,obj2;
        obj1= findCollegeWithMaximumPincode(clg);
        obj2 = searchCollegeByAddress(clg,addr);

        if(obj1==null){
            System.out.println("No college found with mentioned attribute");
        }
        else{
            System.out.println("id-"+ obj1.getId());
            System.out.println("name-"+obj1.getName());
            System.out.println("contactNo-"+obj1.getContact());
            System.out.println("address-"+obj1.getAddr());
            System.out.println("pincode-"+obj1.getPin());
        }
        if(obj2==null){
            System.out.println("No college found with mentioned attribute");
        }
        else{
            System.out.println("id-"+ obj2.getId());
            System.out.println("name-"+obj2.getName());
            System.out.println("contactNo-"+obj2.getContact());
            System.out.println("address-"+obj2.getAddr());
            System.out.println("pincode-"+obj2.getPin());
        }
    }

    //static method 1----
    public static College findCollegeWithMaximumPincode(College[] clg){
        int[] obj= new int[clg.length];
        for(int i=0;i<clg.length;i++){
            obj[i]=clg[i].getPin();
        }
        if(obj.length<1){
            return null;
        }
        Arrays.sort(obj);
        for(int i=0;i<clg.length;i++){
            if(clg[i].getPin()==obj[obj.length-1]){
                return clg[i];
            }
        }
        return null;
    }

    //static method 2--------
    public static College searchCollegeByAddress(College[] clg,String addr){
        for(int i=0;i<clg.length;i++){
            if(clg[i].getAddr().equals(addr)){
                return clg[i];
            }
        }
        return null;
    }
}
