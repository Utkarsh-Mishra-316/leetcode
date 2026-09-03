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
    public ListNode reverseList(ListNode head) {

     ListNode pre1=null;
     ListNode pres=head;
     while(pres!=null){
        ListNode curr=pres.next;
         pres.next=pre1;
         pre1=pres;
         pres=curr;
        if(curr!=null){
            curr=curr.next;
        }
     }
 return pre1;
    }
}