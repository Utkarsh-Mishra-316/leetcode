class Solution {
    static int [] dp;
    static int step(int n,int []dp){
     if(n<=2) return n;
          if(dp[n]!=0) return dp[n];

     int ans=step(n-1,dp)+step(n-2,dp);
     dp[n]=ans;
     return ans;
    }
    public int climbStairs(int n) {
        dp=new int [n+1];
        return step(n,dp);
    }
}