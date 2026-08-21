class Solution {
    public int oddCells(int m, int n, int[][] indices) {
       int [] row=new int[m];
       int [] col=new int[n];
       for(int[] num:indices){
        row[num[0]]++;
        col[num[1]]++;
       } 
       int cnt=0;
       for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if((row[i]+col[j])%2!=0) cnt++;
        }
       }
       return cnt;
    }
}