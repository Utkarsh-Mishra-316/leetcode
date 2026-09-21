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
    public boolean isSymmetric(TreeNode root) {
        return same(root.left ,root.right);
    }
    boolean same(TreeNode root,TreeNode root2){
        if(root==null && root2==null){
            return true;
        }
if(root==null|| root2==null){
            return false;
        }
boolean curr=(root.val==root2.val);
boolean leftt=same(root.left,root2.right);
boolean rightt=same(root.right,root2.left);
return curr&& leftt && rightt;
    }
}