import java.util.*;
class Medicine{
    private String name, batch, disease;
    private int price;

    public Medicine(String name, String batch, String disease, int price){
        this.name=name;
        this.batch=batch;
        this.disease=disease;
        this.price=price;
    }
    public String getName(){
        return name;
    }
    public String getBatch(){
        return batch;
    }
    public String getDisease(){
        return disease;
    }
    public int getPrice(){
        return price;
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Medicine[] med= new Medicine[4];

        for(int i=0;i<4;i++){
            String a= sc.nextLine();
            String b= sc.nextLine();
            String c= sc.nextLine();
            int d= sc.nextInt();sc.nextLine();

            med[i]= new Medicine(a,b,c,d);
        }

        String di= sc.nextLine();
        int[] obj = getPriceByDisease(med,di);
        if(obj==null){
            System.out.println("404 not found");
        }
        else{
            for(int i=0;i<obj.length;i++){
                System.out.println(obj[i]);
            }
        }
    }

    public static int[] getPriceByDisease(Medicine[] med, String disease){
        if(med==null){
            return null;
        }
        int[] obj= new int[0];
        for(int i=0;i<med.length;i++){
            if(med[i].getDisease().equalsIgnoreCase(disease)){
                obj=Arrays.copyOf(obj,obj.length+1);
                obj[obj.length-1]=med[i].getPrice();
            }
        }
        Arrays.sort(obj);
        return obj;
    }
}
