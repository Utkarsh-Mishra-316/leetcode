class Solution {
    public int maxDistance(int[] colors) {
        int max=Integer.MIN_VALUE;;
         int n=colors.length;
         for(int i=n-1;i>0;i--){
            if(colors[i]!=colors[0]){
                max=Math.max(max,i);
                break;
            }
         }
         for(int j=0;j<n;j++){
             if(colors[j]!=colors[n-1]){
                max=Math.max(max,n-1-j);
                break;
            }
         }
         return max;
    }
}