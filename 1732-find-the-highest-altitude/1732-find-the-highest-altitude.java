class Solution {
    public int largestAltitude(int[] gain) {
      int [] ans=new int [gain.length+1];
      ans[0]=0;
      int sum=0;
      for(int i=0;i<gain.length;i++){
        sum+=gain[i];
ans[i+1]=sum;
      }
      int max=0;
      for(int i=0;i<ans.length;i++){
        if(ans[i]>max){
            max=ans[i];
        }
      }
              return max;
    }
} 