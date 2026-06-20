class Solution {
    public boolean validPath(int n, int[][] edges, int start, int end) {
       if(start==end) return true;
        List<List<Integer>> adj=new ArrayList<>();
      for(int i=0;i<n;i++){
        List<Integer> list=new ArrayList<>();
        adj.add(list);
      }
      for(int i=0;i<edges.length;i++){
        int a=edges[i][0];
        int b=edges[i][1];
        adj.get(a).add(b);
         adj.get(b).add(a);
      }
      boolean [] vis=new boolean[n];
      vis[start]=true;
      bfs(start,end,vis,adj);
      return vis[end];
    }
    void bfs(int start,int end,boolean[]vis,List<List<Integer>> adj){
        Queue<Integer> queue=new LinkedList<>();
        queue.add(start);
        while(queue.size()>0){
            int front=queue.remove();
            for(int ele:adj.get(front)){
                if(!vis[ele]){
                    queue.add(ele);
                    vis[ele]=true;
                    if(ele==end) return ;
                }
            }
        }
    }
}