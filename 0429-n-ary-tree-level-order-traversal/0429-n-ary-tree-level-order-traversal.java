/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
         List<List<Integer>> ans=new ArrayList<>();
         if(root==null) return ans;
         Queue<Node> queue=new LinkedList<>();
         queue.offer(root);
         while(!queue.isEmpty()){
            int cs=queue.size();
             List<Integer> res=new ArrayList<>();
            for(int i=0;i<cs;i++){
                Node curr=queue.poll();
             res.add(curr.val);
            if (curr.children != null) {
                    for (Node child : curr.children) {
                        if (child != null) {
                            queue.offer(child);
                        }
                    }
                }
            }
            ans.add(res);
         }
         return ans;
    }
}