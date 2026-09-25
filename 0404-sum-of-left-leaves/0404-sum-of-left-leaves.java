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
    public int sumOfLeftLeaves(TreeNode root) {
        int sum=0;
        if(root==null){
            return sum;
        }
        Queue<TreeNode>queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int cs=queue.size();
            for(int i=0;i<cs;i++){
                TreeNode curr=queue.poll();
 
if(curr.left!=null){

    if(curr.left.left==null && curr.left.right==null){
         
    sum+=curr.left.val;
 
    }else{
    queue.offer(curr.left);
}}
if(curr.right!=null){
    queue.offer(curr.right);
}

            }
        }
        return sum;
    }
}