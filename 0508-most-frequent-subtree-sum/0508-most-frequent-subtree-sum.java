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
    Map<Integer,Integer> map=new HashMap<>();
    int maxcount=0;
    public int[] findFrequentTreeSum(TreeNode root) {
        helper(root);
        List<Integer> res=new ArrayList<>();
        for(int sum :map.keySet()){
           if( map.get(sum)==maxcount){
            res.add(sum);
           }}
           int []result=new int[res.size()];
           for(int i=0;i<res.size();i++){
            result[i]=res.get(i);
           }
return result;
        
    }

    int helper(TreeNode node){
        if(node==null) return 0;
        int leftsum=helper(node.left);
        int rightsum=helper(node.right);
        int currentsum=node.val+leftsum+rightsum;
        int count=map.getOrDefault(currentsum,0)+1;
        map.put(currentsum,count);
        maxcount=Math.max(count,maxcount);
        return currentsum;
    }
}