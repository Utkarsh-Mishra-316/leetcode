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
    public ListNode removeZeroSumSublists(ListNode head) {
 
 ListNode dummy=new ListNode(0);
  
 dummy.next=head;
 ListNode curr=dummy;
 Map<Integer,ListNode> map=new HashMap<>();
 int ps=0;
 while(curr!=null){
    ps+=curr.val;
    map.put(ps,curr);
    curr=curr.next;
 }
 curr=dummy;
ps=0;
while(curr!=null){
    ps+=curr.val;
    curr.next=map.get(ps).next;
    curr=curr.next;
}

      return dummy.next;
    }
}