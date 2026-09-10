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
    private int matchingCount = 0;

    public int averageOfSubtree(TreeNode root) {
        matchingCount = 0;
        dfs(root);
        return matchingCount;
    }

    // Returns an array: [sum of subtree, count of nodes in subtree]
    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        // 1. Post-order: Pehle left aur right resolve karo
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        // 2. Current subtree ka sum aur count aggregate karo
        int currentSum = left[0] + right[0] + node.val;
        int currentCount = left[1] + right[1] + 1;

        // 3. Integer division automatically floor round karta hai
        if (node.val == (currentSum / currentCount)) {
            matchingCount++;
        }

        return new int[]{currentSum, currentCount};
    }
}