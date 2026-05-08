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
//     public ListNode swapNodes(ListNode head, int k) {
//         ListNode first=head;
//         ListNode second=head;
//         ListNode temp=head;
//         for(int i=1;i<k;i++){
//             first=first.next;
//         }
//         temp=first;
//         while(temp.next!=null){
//             temp=temp.next;
//             second=second.next;
//         }
//         int swapvalue=first.val;
//         first.val=second.val;
//         second.val=swapvalue;
//         return head;
//        }

// }
class Solution {
    public ListNode swapNodes(ListNode head, int k) {

        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode curr=head;
        ListNode pre=head;
        int count=0;
     while(curr!=null){
        curr=curr.next;
        count++;
     }
int d= count-k;
for(int i=0;i<d;i++){
    pre=pre.next;
}

     curr=dummy;
 for(int i=0;i<k;i++){
    curr=curr.next;
 }
 
 int temp=curr.val;
 curr.val=pre.val;
 pre.val=temp;
 return dummy.next;

    }}