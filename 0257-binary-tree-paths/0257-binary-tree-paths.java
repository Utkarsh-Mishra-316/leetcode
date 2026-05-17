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
    public List<String> binaryTreePaths(TreeNode root) {
         List<String> answer =new ArrayList<>();
dfs(root,"",answer);
return answer;
        
    }
    public void dfs(TreeNode node,String path, List<String> answer ){
        if(node==null) {return ;}
     path+=node.val;
     if(node.left==null &&  node.right==null){
        answer.add(path);
        return ;
     }
     path+="->";
      dfs(node.left, path, answer);
        dfs(node.right, path, answer);
    }
}