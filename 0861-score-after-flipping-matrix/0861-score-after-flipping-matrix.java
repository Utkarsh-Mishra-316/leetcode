class Solution {
    public int matrixScore(int[][] grid) {
       int m=grid.length;
       int n=grid[0].length;
       int one=0;
       int zero=0;
       int sum=0;
       int pow=1;
       for(int i=0;i<m;i++){
        if(grid[i][0]==0){
 for(int j=0;j<n;j++){
    grid[i][j]^=1;
 }
         }
       }
    for(int j=0;j<n;j++){
       zero=0;
       one=0;
         for(int i=0;i<m;i++){
   if(grid[i][j]==0){
    zero++;
   }
   else{
    one++;
   }}
   if(zero>one){
         for(int i=0;i<m;i++){
         
         grid[i][j]^=1;}
   }
 
 
         
       }

       for(int j=n-1;j>=0;j--){
        one=0;
        for(int i=m-1;i>=0;i--){
            if(grid[i][j]==1){
                one++;
            }
        }
        sum+=one*pow;
        pow*=2;
       }
    return sum;}
}