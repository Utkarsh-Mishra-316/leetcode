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
    public int maxLevelSum(TreeNode root) {
        if(root==null) return -1;
        int count=1;
        int currentlevel=1;
       int maxSum = Integer.MIN_VALUE;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelsum=0;
            int cs=queue.size();
            for(int i=0;i<cs;i++){
       TreeNode curr=queue.poll();
       levelsum+=curr.val;
       if(curr.left!=null){
        queue.offer(curr.left);
       }
       if(curr.right!=null){
        queue.offer(curr.right);
       }
            }
            if(levelsum>maxSum){
                maxSum=levelsum;
                count=currentlevel;
            }
            currentlevel++;
        }
        return count;
    }
}