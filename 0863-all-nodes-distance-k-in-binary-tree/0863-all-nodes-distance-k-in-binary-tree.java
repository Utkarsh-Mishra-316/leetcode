/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;

class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // Step 1: Har node ke parent ka record rakhne ke liye map banaya
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        markParents(root, parentMap);

        // Step 2: Target node se charo taraf (Left, Right, Up) ghumne ke liye BFS queue aur visited set
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        // Target node se shuru karenge
        queue.offer(target);
        visited.add(target);
        
        int currentLevel = 0;

        // BFS chalega jab tak queue khali na ho aur hum k level tak na pahunch jayein
        while (!queue.isEmpty()) {
            // Agar hum exact k distance par pahunch gaye, toh loop rok do
            if (currentLevel == k) {
                break;
            }
            
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                // 1. LEFT DIRECTION: Niche left child par jao
                if (current.left != null && !visited.contains(current.left)) {
                    queue.offer(current.left);
                    visited.add(current.left);
                }

                // 2. RIGHT DIRECTION: Niche right child par jao
                if (current.right != null && !visited.contains(current.right)) {
                    queue.offer(current.right);
                    visited.add(current.right);
                }

                // 3. UP DIRECTION: Upar parent par jao (Map se parent ka address nikal kar)
                TreeNode parent = parentMap.get(current);
                if (parent != null && !visited.contains(parent)) {
                    queue.offer(parent);
                    visited.add(parent);
                }
            }
            // Ek level khatam hone par distance badhao
            currentLevel++;
        }

        // Step 3: Jab loop k level par break hoga, us waqt queue mein bache hue saare nodes humare ans honge
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(queue.poll().val);
        }

        return result;
    }

    // Helper function: Simple Level-Order (BFS) se poore tree mein ghumkar parent mapping karna
    private void markParents(TreeNode root, Map<TreeNode, TreeNode> parentMap) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current.left != null) {
                parentMap.put(current.left, current); // Left child ka parent current hai
                queue.offer(current.left);
            }
            if (current.right != null) {
                parentMap.put(current.right, current); // Right child ka parent current hai
                queue.offer(current.right);
            }
        }
    }
}