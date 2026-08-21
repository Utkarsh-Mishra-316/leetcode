class Solution {
    public int maximumWealth(int[][] accounts) {
        int sum=0;
        int n=accounts.length;
        int m=accounts[0].length;
        int max=0;
        for(int i=0;i<n;i++){
            sum=0;
            for(int j=0;j<m;j++){
                sum+=accounts[i][j];
            }
 if(max<sum){
    max=sum;
 }
        }
        return max;
    }
}