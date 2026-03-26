import java.util.*;
class RRT{
    private int tno, priority;
    private String raised, assign, project;

    public RRT(int tno, String raised, String assign, int priority, String project){
        this.tno= tno;
        this.raised=raised;
        this.assign=assign;
        this.priority=priority;
        this.project=project;
    }
    public int getTno(){
        return tno;
    }
    public String getRaised(){
        return raised;
    }
    public String getAssign(){
        return assign;
    }
    public int getPriority(){
        return priority;
    }
    public String getProject(){
        return project;
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RRT[] rrt= new RRT[4];
        for(int i=0;i<4;i++){
            int a= sc.nextInt();sc.nextLine();
            String b= sc.nextLine();
            String c= sc.nextLine();
            int d= sc.nextInt();sc.nextLine();
            String e= sc.nextLine();

            rrt[i]= new RRT(a,b,c,d,e);
        }
        String ipproject= sc.nextLine();
        RRT obj = getHighestPriorityTicket(rrt, ipproject);
        if(obj==null){
            System.out.println("No such ticket found");
        }
        else{
            System.out.println(obj.getTno());
            System.out.println(obj.getRaised());
            System.out.println(obj.getAssign());
        }
    }

    public static RRT getHighestPriorityTicket(RRT[] rrt, String ipproject){
        RRT[] obj= new RRT[0];
        for(int i=0;i<rrt.length;i++){
            if(rrt[i].getProject().equals(ipproject)){
                obj=Arrays.copyOf(obj,obj.length+1);
                obj[obj.length-1]=rrt[i];
            }
        }
        if(obj.length<1){
            return null;
        }
        if(obj.length==1){
            return obj[0];
        }
        RRT temp;
        for(int i=0;i<obj.length-1;i++){
            if(obj[i+1].getPriority()<obj[i].getPriority()){
                temp=obj[i];
                obj[i]=obj[i+1];
                obj[i+1]=temp;
            }
        }
        return obj[0];

    }
}
