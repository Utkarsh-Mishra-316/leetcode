class Solution {
    public int lengthOfLIS(int[] arr) {
         int n=arr.length;
        int [][]dp=new int[n][n+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=n;j++){
                dp[i][j]=-1;
            }
        }
        return helper(0,-1,arr,dp);
    }
 int helper(int ind,int pre,int []arr,int [][]dp){
     if(ind==arr.length) return 0;
     if(dp[ind][pre+1]!=-1) return dp[ind][pre+1];
     int skip=helper(ind+1,pre,arr,dp);
     if(pre!=-1 && arr[ind]<=arr[pre]) return dp[ind][pre+1]=skip;
     int pick=1+helper(ind+1,ind,arr,dp);
     return dp[ind][pre+1]=Math.max(skip,pick);
    }
}