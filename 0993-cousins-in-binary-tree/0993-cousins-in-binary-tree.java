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
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean isXExist = false;
            boolean isYExist = false;

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();

                // Check agar x aur y is level par hain
                if (curr.val == x) isXExist = true;
                if (curr.val == y) isYExist = true;

                // Sibling Check: Agar dono ek hi parent ke children hain
                if (curr.left != null && curr.right != null) {
                    if ((curr.left.val == x && curr.right.val == y) || 
                        (curr.left.val == y && curr.right.val == x)) {
                        return false; // Same parent means siblings, not cousins
                    }
                }

                // Bachchon ko agli level ke liye queue mein daalo
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }

            // Agar dono ek hi level par mil gaye
            if (isXExist && isYExist) return true;
            
            // Agar ek mil gaya aur dusra nahi, toh cousins nahi ho sakte
            if (isXExist || isYExist) return false;
        }

        return false;
    }
}