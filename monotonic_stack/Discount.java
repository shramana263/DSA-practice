public class Discount {
    public int[] finalPrices(int[] prices) {
        int n= prices.length;
        if(n<1){
            return new int[]{};
        }
        int[] ans= new int[n];
        int i,j;
        for(i=0;i<n-1;i++){
            for(j=i+1;j<n;j++){
                if(prices[j]<=prices[i]){
                    // System.out.println("discount subtracted");
                    ans[i]=prices[i]-prices[j];
                    break;
                }
            }
            if(j==n){
                // System.out.println("no discount");
                // System.out.println(ans[i]+" "+prices[i]);
                ans[i]=prices[i];
                // System.out.println(ans[i]+" "+prices[i]);
            }
        }
        ans[n-1]=prices[n-1];
        return ans;

    }

    public static void main(String[] args){
        int[] nums= {8,4,6,2,3};
        Discount obj = new Discount();
        int[] result = obj.finalPrices(nums);

        for(int i=0;i<result.length;i++){
            System.out.println(result[i]+" ");
        }
    }
}
