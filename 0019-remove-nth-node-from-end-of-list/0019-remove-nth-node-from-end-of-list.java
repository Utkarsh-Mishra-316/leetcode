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
// class Solution {
//     public ListNode removeNthFromEnd(ListNode head, int n) {
//        ListNode dummynode=new ListNode(0);
//        dummynode.next = head;
//        ListNode slow=dummynode;
//        ListNode fast=dummynode;
//        for(int i=0;i<n;i++){
//         fast=fast.next;
//        }
//        while(fast.next!=null){
//         slow=slow.next;
//         fast=fast.next;
        
//        }
//        slow.next=slow.next.next;
//        return dummynode.next;

//     }
// }


class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode curr=head;
        int count =0;
        while(curr!=null){
            curr=curr.next;
            count++;
        }
curr=dummy;
        int d=count-n;
         
      for(int i=0;i<d;i++){
        curr=curr.next;
      }
      if(curr.next!=null){
        curr.next=curr.next.next;
       
      }
        return dummy.next;
    
    }}