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
import java.util.*;

class Solution {
    private int i = 0;
    private List<Integer> flipped = new ArrayList<>();

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        // Reset state for multiple internal tests execution
        i = 0;
        flipped.clear();
        
        // Run DFS traversal. If it returns false, configuration is impossible
        if (dfs(root, voyage)) {
            return flipped;
        } else {
            return Arrays.asList(-1);
        }
    }

    private boolean dfs(TreeNode root, int[] voyage) {
        if (root == null) return true;

        // Core Pattern: Root value must exactly match the expected voyage item
        if (root.val != voyage[i]) {
            return false;
        }
        
        // Move pointer forward since the current root matched perfectly
        i++;

        // Golden Trick: If left child exists but doesn't match the immediate next voyage token, 
        // it means we MUST flip the current parent node.
        if (root.left != null && root.left.val != voyage[i]) {
            flipped.add(root.val); // Mark current parent node as flipped
            
            // Due to the flip, we explore Right subtree FIRST, then Left subtree
            return dfs(root.right, voyage) && dfs(root.left, voyage);
        }

        // Standard Pre-order Path: Explore Left first, then Right
        return dfs(root.left, voyage) && dfs(root.right, voyage);
    }
}