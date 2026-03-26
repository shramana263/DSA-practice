import java.util.*;
class Employee{
    private int id;
    private String name,branch;
    private double rating;
    private boolean ct;

    public Employee(int id, String name, String branch, double rating, boolean ct){
        this.id=id;
        this.name=name;
        this.branch=branch;
        this.rating=rating;
        this.ct=ct;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getBranch(){
        return branch;
    }
    public double getRating(){
        return rating;
    }
    public boolean getCt(){
        return ct;
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Employee[] emp= new Employee[4];
        for(int i=0;i<4;i++){
            int a= sc.nextInt();sc.nextLine();
            String b= sc.nextLine();
            String c= sc.nextLine();
            double d= sc.nextDouble();sc.nextLine();
            boolean e= sc.nextBoolean();sc.nextLine();

            emp[i]= new Employee(a,b,c,d,e);
        }   
        String br= sc.nextLine();

        int ans1= findCountOfEmployeesUsingCompTransport(emp,br);
        System.out.println(ans1==0?"no such employee": ans1);

        Employee ans= findEmployeeWithSecondHighestRating(emp);
        System.out.println(ans==null?"All employee use company transport": ans.getId()+" "+ans.getName());
    }

    public static int findCountOfEmployeesUsingCompTransport(Employee[] emp,String branch){
        if(emp==null){
            return 0;
        }
        int count=0;
        for(int i=0;i<emp.length;i++){
            if(emp[i].getBranch().equals(branch) && emp[i].getCt()){
                count++;
            }
        }
        return count;
    }

    public static Employee findEmployeeWithSecondHighestRating(Employee[] emp){
        if(emp==null){
            return null;
        }
        Employee[] obj= new Employee[0];
        for(int i=0;i<emp.length;i++){
            if(!emp[i].getCt()){
                obj=Arrays.copyOf(obj,obj.length+1);
                obj[obj.length-1]=emp[i];
            }
        }
        if(obj.length<2){
            return null;
        }
        Employee temp;
        for(int i=0;i<obj.length-1;i++){
            if(obj[i+1].getRating()>obj[i].getRating()){
                temp=obj[i];
                obj[i]=obj[i+1];
                obj[i+1]=temp;
            }
        }
        return obj[1];
    }
}
