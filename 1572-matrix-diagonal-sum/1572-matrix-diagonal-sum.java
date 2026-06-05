class Solution {
    public int diagonalSum(int[][] mat) {
         int sum=0;
         int m=mat.length;
         for(int i=0;i<m;i++){
            sum+=mat[i][i];
            int j=m-1-i;
            if(i!=j){
                sum+=mat[i][j];
            }
         }
         return sum;
      
    }
}