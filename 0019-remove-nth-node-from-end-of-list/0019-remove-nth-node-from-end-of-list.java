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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int cnt=0;
        ListNode curr=head;
        while(curr!=null){
            cnt++;
            curr=curr.next;
        }
     curr=head;
     int ans=cnt-n;
     int c0=1;
     if(ans==0){
        return head.next;
     }
     while(curr!=null && c0!=ans){
      c0++;
      curr=curr.next;

     }
     if(curr!=null && curr.next!=null){
 curr.next=curr.next.next;}
 return head;
    }
}