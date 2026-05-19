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
    int min_diff=Integer.MAX_VALUE;


    public int getMinimumDifference(TreeNode root) {
       inorder(root);
        return min_diff;
    }
    void inorder(TreeNode node){
        if(node==null){return ;}
        inorder(node.left);
        if(pre!=null){
int current_diff=node.val-pre.val;
min_diff = Math.min(min_diff, current_diff);
        }
        pre=node;
        inorder(node.right);
    }
}