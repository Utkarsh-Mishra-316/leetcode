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
    // Global variable to keep tracking the cumulative sum of all tilts
    private int totalTilt = 0;

    // Helper function that returns the total sum of nodes in a subtree
    private int calculateSubtreeSum(TreeNode root) {
        // Base Case: If the node is null, its contribution to the sum is 0
        if (root == null) {
            return 0;
        }

        // Step 1: Post-Order execution - deep dive into left and right subtrees
        int leftSum = calculateSubtreeSum(root.left);
        int rightSum = calculateSubtreeSum(root.right);

        // Step 2: The Core Trick - Calculate current node's tilt
        // Tilt is the absolute difference between left and right subtree sums
        int currentTilt = Math.abs(leftSum - rightSum);
        
        // Accumulate this node's tilt into our global counter
        totalTilt += currentTilt;

        // Step 3: Return the total weight of this entire subtree to the parent
        // Total weight = current node's val + total left weight + total right weight
        return root.val + leftSum + rightSum;
    }

    public int findTilt(TreeNode root) {
        // Reset the counter for every new test case execution
        totalTilt = 0;
        
        // Start the bottom-up traversal
        calculateSubtreeSum(root);
        
        // Return the final accumulated tilt sum
        return totalTilt;
    }
}