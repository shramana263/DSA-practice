public class Perimeter {
    public int islandPerimeter(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        int perimeter=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1){
                    if(j-1>=0 && grid[i][j-1]==0 || j-1<0){
                        perimeter++;
                    }
                    if(j+1<cols && grid[i][j+1]==0 || j+1>=cols){
                        perimeter++;
                    }
                    if(i==0){
                        perimeter++;
                    }
                    if(i==rows-1){
                        perimeter++;
                    }
                    if(i-1>=0 && grid[i-1][j]==0){
                        perimeter++;
                    }
                    if(i+1<rows && grid[i+1][j]==0){
                        perimeter++;
                    }
                    
                }
            }
            System.out.println("loop= "+ i +" perimeter= "+perimeter);
        }
        return perimeter;
    }
    public static void main(String args[]){
        int[][] grid={{ 0,1,0,0 },{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        // int[][] grid={{ 1 }};
        Perimeter obj = new Perimeter();
        System.out.println(obj.islandPerimeter(grid));
    }
}
