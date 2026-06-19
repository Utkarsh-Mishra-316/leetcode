class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        boolean vis[]=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                bfs(i,vis,isConnected);
                count++;
            }
           
        }
         return count;
    }

    private void bfs(int i,boolean [] vis,int [][]  isConnected){
           int n=isConnected.length;
           Queue<Integer> queue=new LinkedList<>();
           queue.add(i);
           vis[i]=true;
           while(queue.size()>0){
            int q=queue.remove();
            for(int j=0;j<n;j++){
                if(isConnected[q][j]==1 && vis[j]==false){
                    queue.add(j);
                    vis[j]=true;
                }
            }
           }
    }
}