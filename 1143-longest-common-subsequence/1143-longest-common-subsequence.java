class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        int [][]dp=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;
            }
        }
        return lcs(n-1,m-1,new StringBuilder(text1),new StringBuilder(text2),dp);
    }
    int lcs(int i,int j,StringBuilder text1, StringBuilder text2,int[][]dp){
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(text1.charAt(i)==text2.charAt(j)) return dp[i][j]= 1+lcs(i-1,j-1,text1,text2,dp);
        else return dp[i][j] =Math.max(lcs(i-1,j,text1,text2,dp),lcs(i,j-1,text1,text2,dp));
          
    }
}