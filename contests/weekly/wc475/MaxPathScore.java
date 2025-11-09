
import java.util.Arrays;

public class MaxPathScore {

    private int cellScore(int val){
        if(val==0) return 0;
        if(val==1) return 1;
        if(val==2) return 2;
        return 0;
    }

    private int cellcost(int val){
        if(val==0) return 0;
        if(val==1) return 1;
        if(val==2) return 1;
        return 0;
    }

    public int maxPathScore(int[][] grid, int k) {
        int m=grid.length;
        int n= grid[0].length;

        int[][][] arr = new int[m][n][k+1];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                Arrays.fill(arr[i][j],-1);
            }
        }

        int v00= grid[0][0];
        int s00= cellScore(v00);
        int c00= cellcost(v00);

        if(c00<=k){
            arr[0][0][c00]=s00;
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    continue;
                }

                int vij=grid[i][j];
                int sij=cellScore(vij);
                int cij=cellcost(vij);

                for( int c=cij;c<=k;c++){
                    int prev = c-cij;
                    int maxPrevScore =-1;

                    if(i>0){
                        int scoreUp= arr[i-1][j][prev];
                        maxPrevScore= Math.max(maxPrevScore, scoreUp);
                    }

                    if(j>0){
                        int ScoreLeft= arr[i][j-1][prev];
                        maxPrevScore=Math.max(maxPrevScore, ScoreLeft);
                    }
                    if(maxPrevScore!=-1){
                        arr[i][j][c]= maxPrevScore+sij;
                    }
                }
            }
        }

        int max=-1;
        for(int c=0;c<=k;c++){
            max=Math.max(max,arr[m-1][n-1][c]);
        }

        return max;

    }    

    public static void main(String[] args) {
        int[][] grid= {{ 0,1 },{2,0}};
        int k=1;
        MaxPathScore obj= new MaxPathScore();
        System.out.println(obj.maxPathScore(grid, k));
    }

}
