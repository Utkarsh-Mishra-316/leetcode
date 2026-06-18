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

public class Codec {

    // 1. SERIALIZE: Tree ko String mein badalna (Preorder Traversal)
    public String serialize(TreeNode root) {
        if (root == null) return "";
        
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }
    
    private void serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        
        // Root -> Left -> Right
        sb.append(root.val).append(",");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }

    // 2. DESERIALIZE: String ko wapas Tree mein badalna (Using Range Bounds)
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        
        // String ko split karke saare elements Queue mein daal do
        Queue<Integer> q = new LinkedList<>();
        for (String s : data.split(",")) {
            q.offer(Integer.parseInt(s));
        }
        
        // Initial Range: -Infinity se +Infinity tak
        return deserializeHelper(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private TreeNode deserializeHelper(Queue<Integer> q, int lower, int upper) {
        if (q.isEmpty()) return null;
        
        // Queue ke front element ko check karo bina use nikaale (Peek)
        int val = q.peek();
        
        // 🚨 CRITICAL BST CHECK: Agar value current branch ki range ke bahar hai, 
        // toh yeh is position par nahi lag sakti, null return karo.
        if (val < lower || val > upper) {
            return null;
        }
        
        // Agar range ke andar hai, toh use queue se permanently nikaal lo
        q.poll();
        TreeNode root = new TreeNode(val);
        
        // Left subtree ke liye: Saare elements root.val se chote hone chahiye
        root.left = deserializeHelper(q, lower, root.val);
        
        // Right subtree ke liye: Saare elements root.val se bade hone chahiye
        root.right = deserializeHelper(q, root.val, upper);
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;