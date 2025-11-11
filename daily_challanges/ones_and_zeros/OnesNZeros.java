public class OnesNZeros {
    int dp[][][];

    int[] func(String s){
        int zeros=0,ones=0;
        for(char ch:s.toCharArray()){
            if(ch=='0'){
                zeros++;
            }
            else{
                ones++;
            }
        }
        return new int[]{zeros,ones};
    }

    int helper(int m, int n, int index, String[] strs){
        if(index>=strs.length){
            return 0;
        }

        if(dp[m][n][index]!=-1){
            return dp[m][n][index];
        }

        int[] count= func(strs[index]);
        int zeros= count[0];
        int ones= count[1];

        int take=0;
        if(zeros<=m &&ones<=n){
            take=1+helper(m-zeros,n-ones,index+1,strs);
        }
        int skip= helper(m,n,index+1,strs);

        int ans=Math.max(take,skip);
        dp[m][n][index]=ans;
        return ans;
    }

    public int findMaxForm(String[] strs, int m, int n) {
        dp = new int[m+1][n+1][strs.length];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                for(int k=0;k<strs.length;k++){
                    dp[i][j][k]=-1;
                }
            }
        }

        return helper(m,n,0,strs);
    }

    public static void main(String[] args){
        
    }
}
