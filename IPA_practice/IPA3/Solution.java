import java.util.*;
class Student{
    private int roll;
    private String name, branch;
    private double score;
    private boolean dayScholar;

    public Student(int roll, String name, String branch, double score, boolean dayScholar){
        this.roll= roll;
        this.name=name;
        this.branch=branch;
        this.score=score;
        this.dayScholar=dayScholar;
    }
    public int getRoll(){
        return roll;
    }
    public void setRoll(int roll){
        this.roll=roll;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name= name;
    }
    public String getBranch(){
        return branch;
    }
    public void setBranch(String branch){
        this.branch=branch;
    }
    public double getScore(){
        return score;
    }
    public void setScore(double score){
        this.score=score;
    }
    public boolean getDayScolar(){
        return dayScholar;
    }
    public void setDayScholar(boolean dayScholar){
        this.dayScholar=dayScholar;
    }

}

public class Solution {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        Student[] s= new Student[4];
        for(int i=0;i<4;i++){
            int a= sc.nextInt();sc.nextLine();
            String b= sc.nextLine();
            String c= sc.nextLine();
            double d= sc.nextDouble();sc.nextLine();
            boolean e = sc.nextBoolean();sc.nextLine();

            s[i]= new Student(a,b,c,d,e);
        }
        System.out.println(findCountOfDayscholarStudents(s)==0? "There are no such dayscholar student": findCountOfDayscholarStudents(s));
        Student obj = findStudentwithSecondHighestScore(s);
        if(obj==null){
            System.out.println("there are no student from non day scholar");
        }
        else{
            System.out.println(obj.getRoll()+"#"+obj.getName()+"#"+obj.getScore());
        }
    }

    //static method 1--------
    public static int findCountOfDayscholarStudents(Student[] s){
        int count=0;
        for(int i=0;i<s.length;i++){
            if(s[i].getScore()>80 && s[i].getDayScolar()==true){
                count++;
            }
        }
        return count;
    }

    //static method 2-----
    public static Student findStudentwithSecondHighestScore(Student[] s){
        Student[] obj= new Student[0];
        for(int i=0;i<s.length;i++){
            if(!s[i].getDayScolar()){
                obj=Arrays.copyOf(obj, obj.length+1);
                obj[obj.length-1]=s[i];
            }
        }
        if(obj.length<1){
            return null;
        }
        Student temp;
        for(int i=0;i<obj.length-1;i++){
            if(obj[i+1].getScore()>obj[i].getScore()){
                temp=obj[i];
                obj[i]=obj[i+1];
                obj[i+1]=temp;
            }

        }
        return obj[1];        
    } 

}
