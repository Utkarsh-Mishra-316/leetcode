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
    public int countNodes (TreeNode root) {
        int left=leftheight(root);
        int right=rightheight(root);
        if(left==right){
            return (int) Math.pow(2, left) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    int leftheight(TreeNode root){
        int height=0;
        TreeNode leftNode = root;
        while(leftNode!=null){
            height++;
            leftNode = leftNode.left;
        }
        return height;
    }

     int rightheight(TreeNode root){
        int height=0;
        TreeNode rightNode = root;
        while(rightNode!=null){
            height++;
             rightNode = rightNode.right;
        }
        return height;
    }
}