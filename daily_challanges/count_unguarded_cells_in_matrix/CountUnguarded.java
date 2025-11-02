public class CountUnguarded {

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        
        if(guards.length==0){
            return m*n;
        }

        int[][] grid= new int[m][n];

        for(int[] guard:guards){
            grid[guard[0]][guard[1]]=2;
        }

        for(int[] wall:walls){
            grid[wall[0]][wall[1]]=2;
        }

        int[] distance={-1,0,1,0,-1};

        for(int[] guard:guards){
            for(int i=0;i<4;i++){
                int currRow=guard[0];
                int currCol=guard[1];
                int rowDelta= distance[i];
                int colDelta=distance[i+1];

                while((currRow+rowDelta>=0 && currRow+rowDelta<m) && (currCol+colDelta>=0 && currCol+colDelta<n) && (grid[currRow+rowDelta][currCol+colDelta]<2) ){
                    currRow+=rowDelta;
                    currCol+=colDelta;
                    grid[currRow][currCol]=1;
                }
            }
        }

        int count=0;

        for(int[] row:grid){
            for(int cell:row){
                if(cell==0){
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args){
        int[][] guards = {};
        int[][] walls = {{ 0,1 },{1,0},{2,1},{1,2}};
        CountUnguarded solver = new CountUnguarded();
        int res = solver.countUnguarded(3, 3, guards, walls);
        System.out.println(res);
    }
}
