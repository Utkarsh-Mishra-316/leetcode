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
        
        cnt=cnt-n;
         curr=head;
        int c0=1;
        if(cnt==0) return head.next;
        while(curr!=null && c0!=cnt){
            
             c0++;
    
            curr=curr.next;
        }
        if(curr!=null && curr.next!=null){
            curr.next=curr.next.next;
        }
        return head;
    }
}