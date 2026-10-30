class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int [][] dp=new int[n][amount+1];
        int ans = helper(0, coins, amount, dp);
return ans >= (int)1e9 ? -1 : ans;
    }
    int helper(int i,int[] coins, int amount,int [][]dp){
        if(amount == 0) return 0;
if(i == coins.length) return (int)1e9;
        if(dp[i][amount]!=0) return dp[i][amount];
        int skip=helper(i+1,coins,amount,dp);
        if(amount<coins[i]) return dp[i][amount]=skip;
        int pick=1+helper(i, coins,amount-coins[i],dp);
        return dp[i][amount]=Math.min(pick,skip);
    }
}