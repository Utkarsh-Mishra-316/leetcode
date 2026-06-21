class Solution {
    static boolean ans;
    public boolean isBipartite(int[][] graph) {
 ans=true;
        int n=graph.length;
     int []vis= new  int[n];
     Arrays.fill(vis,-1);
     for(int i=0;i<n;i++){
        if(ans==false) return ans;
        if(vis[i]==-1) bfs(i,vis,graph);
     }
     return ans;
    }
    void bfs(int i,int []vis,int [][]graph){
        vis[i]=0;
        Queue<Integer> queue=new LinkedList<>();
        queue.add(i);
        while(queue.size()>0){
            int front=queue.remove();
            int colou=vis[front];
            for(int ele:graph[front]){
                if(vis[ele]==vis[front]){
                    ans=false;
                    return ;
                }
                if(vis[ele]==-1){
                    vis[ele]=1-colou;
                     queue.add(ele);
                }
                    
            }
        }
    }
}