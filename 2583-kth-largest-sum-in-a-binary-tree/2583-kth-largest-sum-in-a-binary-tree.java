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
    public long kthLargestLevelSum(TreeNode root, int k) {
      List<Long> listsum=new ArrayList<>();
      Queue<TreeNode> queue=new LinkedList<>();
      queue.offer(root);
      while(!queue.isEmpty()){
        int current_size=queue.size();
       long sum=0;
        for(int i=0;i<current_size;i++){
           TreeNode  current=queue.poll();
           sum+=current.val;
           if(current.left!=null){
            queue.offer(current.left);
           }
           if(current.right!=null){
            queue.offer(current.right);
           }
        }
        listsum.add(sum);
      } 
      if(listsum.size()<k){return -1;}
      Collections.sort(listsum);
      return listsum.get(listsum.size() - k);
    }
}