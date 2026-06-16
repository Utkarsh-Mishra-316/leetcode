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
    List<Integer> res=new ArrayList<>();
    void helper(TreeNode root ){
        if(root==null){return;}
        helper(root.left);
       res.add(root.val);
       helper(root.right);
    }
    public int findSecondMinimumValue(TreeNode root) {
        helper(root);
        Collections.sort(res);
        int first=res.get(0);
        for(int i=1;i<res.size();i++){
            if(res.get(i)>first){
                return res.get(i);
            }
        }
        return -1;
    }
}