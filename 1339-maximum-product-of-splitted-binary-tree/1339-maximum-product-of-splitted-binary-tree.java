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
    // Global trackers to maintain the maximum product and absolute total sum
    private long totalSum = 0;
    private long maxProduct = 0;

    public int maxProduct(TreeNode root) {
        // Reset variables for clean state propagation across different test cases
        totalSum = 0;
        maxProduct = 0;
        
        // STEP 1: First DFS to compute the absolute total sum of the entire tree
        totalSum = calculateTotalSum(root);
        
        // STEP 2: Second DFS to scan every subtree sum and compute max product
        findMaxProduct(root);
        
        // STEP 3: Apply the modulo constraint strictly at the very last step
        long modulo = 1000000007;
        return (int) (maxProduct % modulo);
    }

    // DFS 1: Bottom-up reduction to accumulate all node values
    private long calculateTotalSum(TreeNode root) {
        if (root == null) return 0;
        
        return root.val + calculateTotalSum(root.left) + calculateTotalSum(root.right);
    }

    // DFS 2: Post-Order Subtree Scanner
    private long findMaxProduct(TreeNode root) {
        if (root == null) return 0;
        
        // Post-Order Step: First fetch the accumulated sums of left and right branches
        long leftSubtreeSum = findMaxProduct(root.left);
        long rightSubtreeSum = findMaxProduct(root.right);
        
        // Current node's total subtree sum (S1)
        long currentSubtreeSum = root.val + leftSubtreeSum + rightSubtreeSum;
        
        // TRICK: Calculate product if we cut the edge right above this current node
        long remainingTreeSum = totalSum - currentSubtreeSum; // S2 = Total - S1
        long currentProduct = currentSubtreeSum * remainingTreeSum; // Product = S1 * S2
        
        // Maximize the product globally before taking any modulo operations
        maxProduct = Math.max(maxProduct, currentProduct);
        
        // Return the current subtree sum up to the parent frame
        return currentSubtreeSum;
    }
}