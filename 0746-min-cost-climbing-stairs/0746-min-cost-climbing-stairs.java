class Solution {
       static int [] dp;

    public int minCostClimbingStairs(int[] cost) {
         dp=new int[cost.length];
        Arrays.fill(dp,-1);
        return Math.min(cal(0,cost),cal(1,cost));
        
    }
      int cal(int i,int [] cost){
        if(i>=cost.length) return 0;
        if(dp[i]!=-1) return dp[i];
        return dp[i]=cost[i]+Math.min(cal(i+1,cost),cal(i+2,cost));
    
    }
}