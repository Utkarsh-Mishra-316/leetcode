class Solution {
    public int minInsertions(String s) {
        return s.length()-lps(s);
    }
     public   int lps(String s) {
            // code here
            StringBuilder a=new StringBuilder(s);
            StringBuilder b=new StringBuilder(s);
            b.reverse();
            return lcs(a,b);
        }
        public   int lcs(StringBuilder s1, StringBuilder s2) {
                // code here
                int n=s1.length();
                int m=s2.length();
                int [][]dp=new int [n][m];
                for(int i=0;i<n;i++){
                    for(int j=0;j<m;j++){
                        dp[i][j]=-1;
                    }

                }
                return helper(n-1,m-1,new StringBuilder(s1),new StringBuilder(s2),dp);
            }
          public     int helper(int i,int j,StringBuilder a,StringBuilder b,int [][]dp){
                if(i<0 || j<0) return 0;
                if(dp[i][j]!=-1) return dp[i][j];
                if(a.charAt(i)==b.charAt(j)) return dp[i][j]= 1+  helper(i-1,j-1,a,b,dp);
                else return dp[i][j]= Math.max(helper(i-1,j,a,b,dp),helper(i,j-1,a,b,dp));
            }
}