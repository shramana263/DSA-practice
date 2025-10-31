import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for(int i=1;i<=rowIndex;i++){
            // row.clear();
            row.add(1);
            for(int j=1;j<i;j++){
                row.set(j, row.get(j-1)+row.get(j));
            }
            row.add(1);
        }
        return row;
    }

    public static void main(String[] args){
        PascalTriangleII pt= new PascalTriangleII();
        List<Integer> result= pt.getRow(3);
        System.out.println(result);
    }
}
