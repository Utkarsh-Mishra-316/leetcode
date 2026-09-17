class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length<=1) return 0;
        int score=-prices[0];
        int profit=0;
        int cool=0;
        for(int i=1;i<prices.length;i++){
            int hasscore=score;
            int hasprofit=profit;
            int cooldown=cool;
            score=Math.max( hasscore , cooldown-prices[i]);
            profit=hasscore+prices[i];
            cool=Math.max(cooldown,hasprofit);
        }
        return Math.max(profit,cool);

    }
}