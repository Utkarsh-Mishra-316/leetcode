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
    public ListNode mergeNodes(ListNode head) {
        ListNode curr=head.next;
        ListNode dummy=new ListNode(0);
        int sum=0;
        ListNode newNode=dummy;
        while(curr!=null){
 if(curr.val!=0){
    sum+=curr.val;
 }
 else{
     newNode.next=new ListNode(sum);
     
    newNode=newNode.next;
    sum=0;
 }
 curr=curr.next;
        }
        return dummy.next;
    }
}