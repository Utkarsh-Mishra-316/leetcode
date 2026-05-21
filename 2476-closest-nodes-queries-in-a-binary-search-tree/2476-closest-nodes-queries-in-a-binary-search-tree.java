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
    
    public  void inorder(TreeNode root,List<Integer> ans){
if(root==null){
    return ;
}
inorder(root.left,ans);
ans.add(root.val);
inorder(root.right,ans);
    }




    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> sorted=new ArrayList<>();
         inorder(root,sorted);
        for(int target: queries){
            int low=0;
            int high=sorted.size()-1;
            int max=-1;
            int min=-1;
            while(low<=high){
 int mid=low+(high-low)/2;
 int midval=sorted.get(mid);
 if(midval==target){
min=midval;
max=midval;
break;
 }
 else if(midval<target){
    min=midval;
    low=mid+1;
 }
 else{
    max=midval;
    high=mid-1;
 }}
 List<Integer> second =new ArrayList<>();
 second.add(min);
 second.add(max);

result.add(second);
            

        }

return result;
    }
}