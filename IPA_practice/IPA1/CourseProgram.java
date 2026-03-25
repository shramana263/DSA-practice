import java.util.*;
class Course{
		private int courseId, quiz, handson;
		private String courseName, courseAdmin;
		public Course (int courseId ,String courseName, String courseAdmin,int quiz, int handson){
			this.courseId= courseId;
			this.quiz=quiz;
			this.handson=handson;
			this.courseName=courseName;
			this.courseAdmin=courseAdmin;
			
		}
		
		public int getCourseId(){
			return courseId;
		}
		public void setCourseId(int courseId){
			this.courseId= courseId;
		}
		public int getQuiz(){
			return quiz;
		}
		public void setQuiz(int quiz){
			this.quiz= quiz;
		}
		public int getHandson(){
			return handson;
		}
		public void setHandson(int handson){
			this.handson= handson;
		}
		public String getCourseName(){
			return courseName;
		}
		public void setCourseName(String courseName){
			this.courseName=courseName;
		}
		public String getCourseAdmin(){
			return courseAdmin;
		}
		public void setCourseAdmin(String courseAdmin){
			this.courseAdmin=courseAdmin;
		}
		
		
}
public class CourseProgram{
	public static void main(String[] args){
		Course[] course = new Course[4];
		Scanner sc= new Scanner(System.in);
		for(int i=0;i<4;i++){
			int a= sc.nextInt();sc.nextLine();
			String b= sc.nextLine();
			String c=sc.nextLine();
			int d= sc.nextInt();sc.nextLine();
			int e= sc.nextInt();sc.nextLine();
			course[i]= new Course(a,b,c,d,e);
		}
		String admin= sc.nextLine();
		int handson= sc.nextInt();sc.nextLine();
		System.out.println(findAvgOfQuizByAdmin(course,admin)==0?"No course found":findAvgOfQuizByAdmin(course,admin));
		Course[] obj1= sortCourseByHandsOn(course, handson);
		if(obj1==null){
			System.out.println("No Course found with mentioned attribute.");
		}
		else{
			for(int i=0;i<obj1.length;i++){
				System.out.println(obj1[i].getCourseName());
			}
		}
	}

	public static int findAvgOfQuizByAdmin(Course[] course, String admin){
		int sum=0, count=0;
		for(int i=0;i<course.length;i++){
			if(course[i].getCourseAdmin().equals(admin)){
				sum+=course[i].getQuiz();
				count++;
			}
		}
		if(sum>0){
			return sum/count;
		}
		else{
			return 0;
		}
	}

	public static Course[] sortCourseByHandsOn(Course[] course, int handson){
		Course[] obj = new Course[0];
		for(int i=0;i<course.length;i++){
			if(course[i].getHandson()<handson){
				obj= Arrays.copyOf(obj, obj.length+1);
				obj[obj.length-1]=course[i];
			}
		}
		Course temp;
		for(int i=0;i<obj.length-1;i++){
			if(obj[i+1].getHandson()>obj[i].getHandson()){
				temp=obj[i];
				obj[i]=obj[i+1];
				obj[i+1]=temp;
			}
		}
		if(obj.length>0){return obj;}
		else{return null;}
		
	}

}







