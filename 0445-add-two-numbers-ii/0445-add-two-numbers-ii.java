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
    public ListNode reverse(ListNode head){
        ListNode pre=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode nextnode=curr.next;
            curr.next=pre;
            pre=curr;
            curr=nextnode;
        }
        return pre;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
          l1=reverse(l1);
          l2=reverse(l2);
          int carry=0;
          ListNode dummy=new ListNode(0);
          ListNode curr=dummy;
          while(l1!=null || l2!=null || carry!=0){
            int sum=carry;
 if(l1!=null){
    sum+=l1.val;
    l1=l1.next;
 }
 if(l2!=null){
    sum+=l2.val;
    l2=l2.next;
 }
 ListNode Node=new ListNode(sum%10);
 curr.next=Node;
 curr=Node;
 carry=sum/10;

          }
          return reverse(dummy.next);
    }
}