class Solution {
    public int maxProfit(int[] prices) {
      int profit=Integer.MIN_VALUE;
      int diff=prices[0];
      int sum=0;

      for(int i=1;i<prices.length;i++){
         
        if(diff>prices[i]){
 diff=prices[i];

        }
     sum=prices[i]-diff;
     profit=Math.max(profit,sum);
      }
      if(profit>0){
        return profit;
      }
      return 0;
       
}}