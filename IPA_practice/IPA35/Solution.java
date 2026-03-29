import java.util.Arrays;
import java.util.Scanner;
class Car{
    private int id;
    private String name, type;

    public Car(int id, String name, String type){
        this.id=id;
        this.name=name;
        this.type=type;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public String getType(){
        return type;
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Car[] car= new Car[5];
        for(int i=0;i<5;i++){
            int a= sc.nextInt();sc.nextLine();
            String b= sc.nextLine();
            String c = sc.nextLine();

            car[i]= new Car(a,b,c);
        }
        int id= sc.nextInt();sc.nextLine();
        Car[] obj = RemoveAndRearrange(car, id);
        if(obj==null){
            System.out.println("404 not found");
        }
        else{
            for(Car o:obj){
                System.out.println(o.getId()+":"+o.getName());
            }
        }
        sc.close();
    }

    public static Car[] RemoveAndRearrange(Car[] car, int id){
        Car[] obj= new Car[0];
        for(Car c:car){
            if(c.getId()!=id){
                obj=Arrays.copyOf(obj,obj.length+1);
                obj[obj.length-1]=c;
            }
        }
        if(obj.length<1){
            return null;
        }

        return obj;
    }
    // public static Car[] RemoveAndRearrange(Car[] car, int id){
    //     Car[] obj= new Car[0];
    //     int curr, prev;
    //     int i=0;
    //     while(car[i].getId()!=id){
    //         obj=Arrays.copyOf(obj,obj.length+1);
    //         obj[obj.length-1]=car[i];
    //         i++;
    //     }
    //     prev=car[i].getId();
    //     for(int j=i+1;j<car.length;j++){
    //         obj=Arrays.copyOf(obj,obj.length+1);
    //         obj[obj.length-1]=car[j];
    //         curr=car[j].getId();
    //         obj[obj.length-1].setId(prev);
    //         prev=curr;
    //     }
    //     if(obj.length<1){
    //         return null;
    //     }

    //     return obj;
    // }
}
