class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m=mat.length;
        int n=mat[0].length;
         PriorityQueue<int [] > pq=new PriorityQueue<>((a,b)->{
            if(a[0]!=b[0]){
                return b[0]-a[0];
            }
            return b[1]-a[1];
         }
         );
         for(int i=0;i<m;i++){
            int soldier=0;
            for(int j=0;j<n;j++){
                if(mat[i][j]==1){
                    soldier++;
                }
                else{
                    break;
                }

            }
            pq.offer(new int []{soldier,i});
            if(pq.size()>k){
                pq.remove();
            }
         }
         int [] ans=new int[k];
         for(int i=k-1;i>=0;i--){
            ans[i]=pq.poll()[1];
         }
        return ans;
    }
}