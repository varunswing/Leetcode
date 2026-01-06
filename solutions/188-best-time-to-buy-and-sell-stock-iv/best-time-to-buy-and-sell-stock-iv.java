class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }

        int n = prices.length;

        if (k >= n/2){
            int prof = 0;
            for(int i = 1; i<n; i++){
                if(prices[i] > prices[i-1]){
                    prof +=  prices[i] - prices[i-1];
                }
            }

            return prof;
        }

        int[] buy = new int[k];
        int[] sell = new int[k];

        for(int i=0; i<k; i++){
            buy[i] = Integer.MIN_VALUE;
        }

        for(int price : prices){
            for(int i=0; i<k; i++){
                if(i==0){
                    buy[i] = Math.max(buy[i], - price);
                }else{
                    buy[i] = Math.max(buy[i], sell[i-1] - price);
                }
                sell[i] = Math.max(sell[i], buy[i] + price);
            }
        }

        return sell[k-1];
    }
}
