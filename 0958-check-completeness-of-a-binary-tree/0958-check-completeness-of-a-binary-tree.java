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
    static int s;
    public boolean isCompleteTree(TreeNode root) {
        s=size(root);
        return isbst(root,1);
    }
    boolean isbst(TreeNode root,int ind){
 if(root==null) return true;
        if(ind>s) return false;
        return isbst(root.left,2*ind) && isbst(root.right,2*ind+1);
    }
    int size(TreeNode root){
        if(root==null) return 0;
        return 1+size(root.left)+size(root.right);
    }
}