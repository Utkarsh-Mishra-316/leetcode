class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){adj.add(new ArrayList<>());}
        int []indegree=new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            int a=prerequisites[i][0],b=prerequisites[i][1];
            adj.get(b).add(a);
            indegree[a]++;
        }
        Queue<Integer> q=new LinkedList<>();
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while(q.size()>0){
           int front=q.remove();
           ans.add(front);
           for(int ele:adj.get(front)){
            indegree[ele]--;
            if(indegree[ele]==0) q.add(ele);
           } 
        }
        if(ans.size()==numCourses) return true;
        else return false;
    }
}