import java.util.Arrays;
import java.util.Scanner;
class Student{
    private int roll;
    private String name,sub,date;
    private char grade;

    public Student(int roll, String name, String sub, char grade, String date){
        this.roll=roll;
        this.name=name;
        this.sub=sub;
        this.grade=grade;
        this.date=date;
    }
    public int getRoll(){
        return roll;
    }
    public String getName(){
        return name;
    }
    public String getSub(){
        return sub;
    }
    public char getGrade(){
        return grade;
    }
    public String getDate(){
        return date;
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Student[] s= new Student[4];
        for(int i=0;i<4;i++){
            int a= sc.nextInt();sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            char d= sc.nextLine().charAt(0);
            String e= sc.nextLine();

            s[i]= new Student(a,b,c,d,e);
        }
        char grade= sc.nextLine().charAt(0);
        int month=sc.nextInt();sc.nextLine();
        Student[] obj= findStudentByGradeAndMonth(s,grade,month);
        if(obj==null){
            System.out.println("404 not found");
        }
        else{
            for(Student o:obj){
                System.out.println(o.getName()+"::"+o.getSub());
            }
            System.out.println(obj.length);
        }
    }

    public static Student[] findStudentByGradeAndMonth(Student[] student, char grade, int month){
        Student[] obj=new Student[0];
        for(Student s:student){
            if(s.getGrade()==grade && Integer.parseInt(s.getDate().substring(3,5))==month){
                obj= Arrays.copyOf(obj,obj.length+1);
                obj[obj.length-1]=s;
            }
        }
        if(obj.length<1){
            return null;
        }
        return obj;
    }
}
