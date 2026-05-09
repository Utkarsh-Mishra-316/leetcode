/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
         List<List<Integer>> result=new ArrayList<>();
         boolean reverse =false;
         if(root==null){
            return result;
         }
         Deque<TreeNode> queue=new LinkedList<>();
         queue.offer(root);
         while(!queue.isEmpty()){
            int currentsize=queue.size();
            List<Integer> currentlevel=new ArrayList<>(currentsize);
            for(int i=0;i<currentsize;i++){
                if(!reverse){
                    TreeNode currentnode=queue.pollFirst();
                    currentlevel.add(currentnode.val);
                     if(currentnode.left!=null){
                       queue.addLast(currentnode.left);
                    }
                     if(currentnode.right!=null){
                       queue.addLast(currentnode.right);
                    }
                   
                   
                }
                else{
                   TreeNode currentnode=queue.pollLast();
                    currentlevel.add(currentnode.val);
                    if(currentnode.right!=null){
                        queue.addFirst(currentnode.right);
                    } 
                    if(currentnode.left!=null){
                        queue.addFirst(currentnode.left);
                    }
                    
                }
            }
                reverse=!reverse;

            result.add(currentlevel);
         }
         return result;
    }
}