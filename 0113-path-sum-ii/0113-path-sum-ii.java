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
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
         List<List<Integer>> res = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
          findpath(root,targetSum,res,currentPath);
          return res;
                                            
                                                
}
public void findpath(TreeNode root,int targetSum,List<List<Integer>> res ,List<Integer> currentPath ){
    if(root==null) return ;
    currentPath.add(root.val);
    if(  root.left==null && root.right==null && root.val==targetSum){
    res.add(new ArrayList<>(currentPath));
}
else{
findpath(root.left,targetSum-root.val,res,currentPath);
findpath(root.right,targetSum-root.val,res,currentPath);

}
currentPath.remove(currentPath.size() - 1);
}}