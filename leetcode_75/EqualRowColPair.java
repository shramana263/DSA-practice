
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EqualRowColPair {

    public int equalPairs(int[][] grid) {

        int count=0;
        int m=grid.length;
        Map<List<Integer>,Integer> rowcount= new HashMap<>();

        for(int i=0;i<m;i++){
            List<Integer> row = new ArrayList<>();
            for(int el:grid[i]){
                row.add(el);
            }
            rowcount.put(row,rowcount.getOrDefault(row, 0)+1);
        }

        for(int i=0;i<m;i++){
            List<Integer> col= new ArrayList<>();
            for(int j=0;j<m;j++){
                col.add(grid[j][i]);
            }

            if(rowcount.containsKey(col)){
                count+=rowcount.get(col);
            }
        }
        return count;
    }

    public static void main(String[] args){
        int[][] grid = {{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}};
        EqualRowColPair obj= new EqualRowColPair();
        System.out.println(obj.equalPairs(grid));
    }
}
