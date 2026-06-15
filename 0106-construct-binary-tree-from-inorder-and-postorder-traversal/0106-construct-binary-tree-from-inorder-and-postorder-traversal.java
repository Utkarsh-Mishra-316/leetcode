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
    int postindex;
    Map<Integer,Integer> map=new HashMap<>();
    TreeNode helper(int postorder [],int start,int end){
        if(start>end) return null;
         int rootval=postorder[postindex];
         TreeNode root=new TreeNode(rootval);
         postindex--;
         int rootindex=map.get(rootval);
         root.right=helper(postorder,rootindex+1,end);
         root.left=helper(postorder,start,rootindex-1);
         return root;



    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postindex=  postorder.length-1;
        for(int i=0;i<inorder.length;i++){
            map.put(inorder [i],i);
        }
        return helper(postorder ,0,postindex);
    }
}