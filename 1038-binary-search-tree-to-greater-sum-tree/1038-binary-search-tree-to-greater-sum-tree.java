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
    static int sum;
    public TreeNode bstToGst(TreeNode root) {
         sum=0;
        reversetree(root);
        return root;
    }
    static void reversetree(TreeNode root){
        if(root==null) return ;
        reversetree(root.right);
        sum+=root.val;
        root.val=sum;
        reversetree(root.left);

    }
}