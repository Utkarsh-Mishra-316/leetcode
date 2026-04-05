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
    public ListNode swapPairs(ListNode head) {
        if(head==null ||head.next==null) return head;
        ListNode pre=null;
        ListNode first=head;
        ListNode second=first.next;
        
        while(first!=null && second !=null){
            ListNode third=second.next;
            second.next=first;
            first.next=third;
            if(pre!=null){
            pre.next=second;}
            else{
                head=second;
            }
            pre=first;
            first=third;
            if(third!=null){
            second=third.next;}
            else{
                second=null;
            }
            

        }
        return head;
    }
}