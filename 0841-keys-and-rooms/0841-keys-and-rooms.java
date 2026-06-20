class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        boolean vis[]=new boolean [n];
        vis[0]=true;
        bfs(0,vis,rooms);
        for(boolean  ele:vis){
            if(!ele){
                return false;
            }
        }
        return true;
    }
    void bfs(int start,boolean vis[],List<List<Integer>> rooms){

        Queue<Integer> queue=new LinkedList<>();
        queue.add(start);
        while(queue.size()>0){
            int front=queue.remove();
            for(int ele:rooms.get(front)){

                if(!vis[ele]){
                    vis[ele]=true;
                    queue.add(ele);
                }
            }
        }
    }
}