class BuySellStocks{
    public int maxProfit(int[] prices) {
        // Code here
        int min=prices[0];
        int profit=0;
        for(int i=0;i<prices.length;i++){
            min = Math.min(min, prices[i]);
            profit= Math.max(profit, prices[i]-min);
            
        }
        return profit;
    }
}