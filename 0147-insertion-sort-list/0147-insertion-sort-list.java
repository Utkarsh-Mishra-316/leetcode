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
    public ListNode insertionSortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode dummy=new ListNode(0);

        ListNode curr=head;
         while(curr!=null){
            ListNode pre=dummy;
            ListNode nextnode=curr.next;
            while( pre.next!=null && pre.next.val<curr.val){
                pre=pre.next;
            }
             curr.next=pre.next;
             pre.next=curr;
             curr=nextnode;
        }
        
return dummy.next;
    }
}