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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // Base Case 1: Agar pehla tree null hai, toh doosra hi hamara answer hai
        if (root1 == null) return root2;
        
        // Base Case 2: Agar doosra tree null hai, toh pehla hi hamara answer hai
        if (root2 == null) return root1;
        
        // Overlap Moment: Dono valid hain, toh root1 me dono ka sum store kar do
        root1.val += root2.val;
        
        // Parallel Dive: Left children ko ek sath aur Right children ko ek sath merge karo
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        
        // Return the fully merged root1 tree
        return root1;
    }
}