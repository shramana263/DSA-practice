import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class UnionFind{
    int[] root;
    public UnionFind(int size){
        root = new int[size];
        for(int station =1;station<size;station++){
            root[station]= station;
        }
    }

    public int find(int x){
        if(x!=root[x]){
            root[x]=find(root[x]);//path compression
        }

        return root[x];

    }

    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);

        root[rootY]=rootX;
    }

}

public class PowerGrid {

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        UnionFind uf = new UnionFind(c+1);
        boolean[] status= new boolean[c+1];
        Arrays.fill(status,true);
        Map<Integer, PriorityQueue<Integer>> grid = new HashMap<>();

        for( int[] conn: connections){
            uf.union(conn[0], conn[1]);
        }

        for(int station=1; station<=c; station++){
            int root = uf.find(station);

            grid.putIfAbsent(root, new PriorityQueue<>());
            grid.get(root).add(station);
        }

        List<Integer> result = new ArrayList<>();

        for(int[] query:queries){
            int sts = query[0];
            int station= query[1];

            if(sts==2){
                status[station] = false;
            }
            else if(status[station]==true){
                result.add(station);
            }
            else{
                int root =uf.find(station);
                PriorityQueue<Integer> heap = grid.getOrDefault(root, new PriorityQueue<>());

                while (!heap.isEmpty() && status[heap.peek()]==false){
                    heap.poll();
                }

                int nearestStation = heap.isEmpty()?-1:heap.peek();
                result.add(nearestStation);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }


    public static void main(String[] args){
        int[][] connections = {{1,2},{2,3},{3,4},{4,5}};
        int[][] queries = {{1,3},{2,1},{1,1},{2,2},{1,2}};
        int c=5;
        PowerGrid obj= new PowerGrid();
        int[] result= obj.processQueries(c, connections, queries);
        
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }
    
}
