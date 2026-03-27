import java.util.Scanner;
class NavalVessel{
    private int id, plan, completed;
    private String name, purpose, classf;

    public NavalVessel(int id, String name, int plan, int completed, String purpose){
        this.id=id;
        this.name= name;
        this.plan=plan;
        this.completed=completed;
        this.purpose=purpose;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getPlan(){
        return plan;
    }
    public int getCompleted(){
        return completed;
    }
    public String getPurpose(){
        return purpose;
    }
    public String getClassf(){
        return classf;
    }
    public void setClassf(String classf){
        this.classf=classf;
    }

}

public class Solution {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in); 
        NavalVessel[] nv= new NavalVessel[4];
        for(int i=0;i<4;i++){
            int a = sc.nextInt();sc.nextLine();
            String b = sc.nextLine();
            int c= sc.nextInt();sc.nextLine();
            int d= sc.nextInt();sc.nextLine();
            String e= sc.nextLine();

            nv[i]= new NavalVessel(a,b,c,d,e);
        }

        int per= sc.nextInt();sc.nextLine();
        String purpose= sc.nextLine();

        int ans= findAvgVoyagesByPct(nv,per);
        System.out.println(ans==0?"404 not found":ans);

        NavalVessel obj= findVesselByGrade(nv,purpose);
        System.out.println(obj==null?"404 not found":obj.getName()+"::"+obj.getClassf());
    }

    public static int findAvgVoyagesByPct(NavalVessel[] nv, int percent){
        int sum=0;
        int count=0;
        for(NavalVessel n:nv){
            if((n.getCompleted()*100)/n.getPlan()>=percent){
                sum+=n.getCompleted();
                count++;
            }
        }
        if(sum==0){
            return 0;
        }
        return sum/count;
    }

    public static NavalVessel findVesselByGrade(NavalVessel[] nv, String purpose){
        for(NavalVessel n:nv){
            if(n.getPurpose().equalsIgnoreCase(purpose)){
                int percentage= (n.getCompleted()*100)/n.getPlan();
                if(percentage==100){
                    n.setClassf("Star");
                }
                else if(percentage>=80 && percentage<=99){
                    n.setClassf("Leader");
                }
                else if(percentage>=79 && percentage<=55){
                    n.setClassf("Inspirer");
                }
                else{
                    n.setClassf("Striver");
                }
                return n;
            }
        }
        return null;
    }
}
