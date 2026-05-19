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
    private TreeNode pre=null;
    int max=0;
    int current_max=0;
    private List<Integer> modes = new ArrayList<>();
    public int[] findMode(TreeNode root) {
  inorder(root);
    int [] result=new int[modes.size()];
    for(int i=0;i<modes.size();i++){
        result[i]=modes.get(i);
    }
    return result;}
    public void inorder(TreeNode node) {
        if(node==null){
            return ;
        }
        inorder(node.left);
        if(pre!=null && pre.val==node.val){
            max++;
        }
        else{
            max=1;
        }
        if(max>current_max){
            current_max=max;
            modes.clear();
            modes.add(node.val);
        }
        else if(max==current_max){
      modes.add(node.val);
        }
        pre=node;
        inorder(node.right);
    }
}