class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int sum=0;
        int i=0;
       
      
        while(i<worker.length  ){
             int j=0;
               int max=0;
        
                while(j<difficulty.length   ){
if(worker[i]>=difficulty[j]){
                   max= Math.max(max,profit[j]);
                  }j++;
            }
             
            sum+=max;
            i++;
        }
        return sum;
    }
}