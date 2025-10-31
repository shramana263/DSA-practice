
import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle= new ArrayList<>();
        List<Integer> row= new ArrayList<>();
        for(int i=0;i<numRows;i++){
            for(int j=0;j<=i;j++){
                if(j==0 || j==i){
                    row.add(1);
                }
                else{
                    row.add(triangle.get(i-1).get(j-1)+ triangle.get(i-1).get(j));
                }

            }
            triangle.add(new ArrayList<>(row));
            row.clear();

        }

        return triangle;
    }

    public static void main(String[] args){
        PascalTriangle pt= new PascalTriangle();
        List<List<Integer>> result= pt.generate(5);
        for(List<Integer> row: result){
            System.out.println(row);
        }
    }
}
