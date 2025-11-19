import java.util.ArrayDeque;
import java.util.Deque;

public class StudentsUnableToEat {
    public int countStudents(int[] students, int[] sandwiches) {
        int n=students.length;
        Deque<Integer> queue= new ArrayDeque<>();
        for (int student : students) {
            queue.addLast(student); 
        }
        int top=0;
        int i=0;
        while(!queue.isEmpty() && top<n){
            if(queue.peekFirst()==sandwiches[top]){
                queue.removeFirst();
                top++;
                i=0;
            }
            else{
                queue.addLast(queue.removeFirst());
                i++;
            }
            if (i == queue.size()) {
                break; 
            }
        }
        return queue.size();
    }

    public static void main(String[] args) {
        int[] students={1,1,0,0};
        int[] food={0,1,0,1};

        StudentsUnableToEat obj= new StudentsUnableToEat();
        System.out.println(obj.countStudents(students, food));
    }
}
