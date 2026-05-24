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
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return ismirror(root.left,root.right);
        }
        public boolean ismirror(TreeNode r1 ,TreeNode r2){
            if(r1==null && r2==null ){return true;}
            if(r1==null || r2==null) return false;
         boolean current=(r1.val==r2.val);
         boolean leftside=ismirror(r1.left,r2.right);
         boolean rightside=ismirror(r1.right,r2.left);
         return current && leftside && rightside ;
        
        }
        }
//        Queue<TreeNode> queue=new LinkedList<>();
//        queue.add(root.left);
//        queue.add(root.right);
//        while(!queue.isEmpty()){
//         TreeNode left=queue.poll();
        
//         TreeNode right=queue.poll();
//         if(left==null && right==null){
//             continue;
//         }
//         if(left==null || right == null){
//             return false;
//         }
//         if(left.val!=right.val){
//             return false;
//         }
//         queue.add(left.left);
//         queue.add(right.right);
//         queue.add(left.right);
//         queue.add(right.left);
//        }        
//  return true;

//     }
// }