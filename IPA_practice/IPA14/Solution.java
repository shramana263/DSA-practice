import java.util.Arrays;
import java.util.Scanner;
class Movie{
    private String name, com, gen;
    private int budget;

    public Movie(String name, String com, String gen, int budget){
        this.name= name;
        this.com=com;
        this.gen=gen;
        this.budget=budget;
    }

    public String getName(){
        return name;
    }
    public String getCom(){
        return com;
    }
    public String getGen(){
        return gen;
    }
    public int getBudget(){
        return budget;
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);   
        Movie[] m= new Movie[4];
        for(int i=0;i<4;i++){
            String a= sc.nextLine();
            String b= sc.nextLine();
            String c= sc.nextLine();
            int d= sc.nextInt();sc.nextLine();

            m[i]= new Movie(a,b,c,d);
        }
        String search= sc.nextLine();

        Movie[] obj= getMovieByGenre(m,search);
        if(obj==null){
            System.out.println("404 not found");
        }
        else{
            for(Movie o:obj){
                System.out.println(o.getBudget()>80000000?"High budget movie":"low budget movie");
            }
        }
    }

    public static Movie[] getMovieByGenre(Movie[] movies, String searchGen){
        Movie[] obj= new Movie[0];
        for(Movie m:movies){
            if(m.getGen().equalsIgnoreCase(searchGen)){
                obj=Arrays.copyOf(obj,obj.length+1);
                obj[obj.length-1]=m;
            }
        }
        if(obj.length<1){
            return null;
        }
        return obj;
    }
}
