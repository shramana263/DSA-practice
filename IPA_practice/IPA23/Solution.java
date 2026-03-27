import java.util.Scanner;
class Institution{
    private int id, placed, cleared;
    private String name, loc, grade;

    public Institution(int id, String name, int placed, int cleared ,String loc){
        this.id=id;
        this.name=name;
        this.placed=placed;
        this.cleared=cleared;
        this.loc=loc;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getPlaced(){
        return placed;
    }
    public int getCleared(){
        return cleared;
    }
    public String getLoc(){
        return loc;
    }
    public String getGrade(){
        return grade;
    }
    public void setGrade(String grade){
        this.grade=grade;
    }
}
public class Solution {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Institution[] ins= new Institution[4];
        for(int i=0;i<4;i++){
            int a= sc.nextInt();sc.nextLine();
            String b= sc.nextLine();
            int c= sc.nextInt();sc.nextLine();
            int d= sc.nextInt();sc.nextLine();
            String e= sc.nextLine();

            ins[i]= new Institution(a,b,c,d,e);
        }
        String loc= sc.nextLine();
        String name=sc.nextLine();
        int ans= FindNumClearancedByLoc(ins,loc);
        System.out.println(ans==0?"404 not found":ans);

        Institution obj = UpdateInstitutionGrade(ins, name);
        System.out.println(obj==null?"404 not found": obj.getName()+"::"+obj.getGrade());
        sc.close();
    }

    public static int FindNumClearancedByLoc(Institution[] ins, String loc){
        int sum=0;
        for(Institution i:ins){
            if(i.getLoc().equalsIgnoreCase(loc)){
                sum+=i.getCleared();
            }
        }
        return sum;
    }

    public static Institution UpdateInstitutionGrade(Institution[] ins, String name){
        for(Institution i:ins){
            if(i.getName().equalsIgnoreCase(name)){
                int rating = (i.getPlaced()*100)/i.getCleared();
                if(rating>=80){
                    i.setGrade("A");
                }
                else{
                    i.setGrade("B");
                }
                return i;
            }
        }
        return null;
    }
}
