// Find the first non repeated character substring
//Arijit = Arij
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class FirstLongestNonrepeatedSubStr{
    public static void main(String[] args){
        List<Character> list = new ArrayList<>();
        Scanner sc= new Scanner(System.in);
        String s= sc.nextLine();
        for(int i=0;i<s.length();i++){
            if(list.contains(s.charAt(i))){
                break;
            }
            list.add(s.charAt(i));
        }
        System.out.println(list);
        sc.close();
    }
}