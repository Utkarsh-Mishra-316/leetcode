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
    int maxcount=0;
    int dfs(TreeNode node){
        if (node == null) return 0;
      int leftside=dfs(node.left);
      int rightside=dfs(node.right);
      int rightcount=0;
      int leftcount=0;
      if(node.left!=null && node.val==node.left.val){
        leftcount=leftside+1;
      }
      if(node.right!=null && node.val==node.right.val){
      rightcount=rightside+1;
      }
      maxcount=Math.max(maxcount,leftcount+rightcount);
      return Math.max(leftcount,rightcount);
    }
    public int longestUnivaluePath(TreeNode root) {
        if(root==null){
            return 0;
        }
        dfs(root);
        return maxcount;
    }
}