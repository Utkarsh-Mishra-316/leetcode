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
    public boolean helper(TreeNode node, Integer low, Integer high) {
        // Base case: Null node hamesha valid hota hai
        if (node == null) return true;

        // Low boundary check: node.val <= low nahi hona chahiye
        if (low != null && node.val <= low) return false;

        // High boundary check: node.val >= high nahi hona chahiye
        if (high != null && node.val >= high) return false;

        // Left subtree ke liye: High boundary ab current node ki value hogi
        // Right subtree ke liye: Low boundary ab current node ki value hogi
        boolean leftnode = helper(node.left, low, node.val);
        boolean rightnode = helper(node.right, node.val, high);

        return leftnode && rightnode;
    }

    public boolean isValidBST(TreeNode root) {
        // Initial call mein koi range nahi hoti (null, null)
        return helper(root, null, null);
    }
}