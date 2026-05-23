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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int bottomLeftVal = root.val;
        while(!queue.isEmpty()){
        int current_size=queue.size();
        for(int i=0;i<current_size;i++){
          TreeNode curr=queue.poll();
          if(i==0  ){
           bottomLeftVal = curr.val;
          } 
          if(curr.left!=null){
            queue.offer(curr.left);
          } 
          if(curr.right!=null){
            queue.offer(curr.right);
          }
        }
        }
        return  bottomLeftVal  ;
    }
}