/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        ListNode curr=head;
        List<Integer> ans=new ArrayList<>();
        ListNode Next=head;
        while(curr!=null){
            int value=0;
            Next=curr.next;
        while(Next!=null){
if(curr.val<Next.val){
    value=Next.val;

  break;
}
 
Next=Next.next;
        }
        ans.add(value);
        curr=curr.next;
        }
        int []result=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            result[i]=ans.get(i);
        }
        return result;
    }
}