
import java.util.ArrayList;
import java.util.List;

public class PascalTriangleOpt {
    
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle= new ArrayList<>();
        if(numRows<=0) return triangle;
        triangle.add(List.of(1)); 
        for(int i=1;i<numRows;i++){
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow= triangle.get(i-1);
            row.add(1);
            for(int j=1;j<i;j++){
                row.add(prevRow.get(j-1)+prevRow.get(j));
            }
            row.add(1);
            triangle.add(row);
        }


        return triangle;
    }

    public static void main(String[] args){
        PascalTriangleOpt pt= new PascalTriangleOpt();
        List<List<Integer>> result= pt.generate(5);
        for(List<Integer> row: result){
            System.out.println(row);
        }
    }
}
