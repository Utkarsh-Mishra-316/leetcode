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
   TreeNode pre=null;
   TreeNode first=null;
   TreeNode sec=null;
    void inorder(TreeNode root){
 if(root==null) return ;
 inorder(root.left);
if(pre!=null && pre.val>root.val){
    if(first==null){
        first=pre;
    }
    sec=root;
 }
 pre=root;
 inorder(root.right);
  
    }
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp=first.val;
        first.val=sec.val;
        sec.val=temp;
        
    }
}