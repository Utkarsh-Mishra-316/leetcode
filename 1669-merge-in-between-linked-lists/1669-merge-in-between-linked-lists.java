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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode after=list1;
     for(int i=0;i<a-1;i++){
        after=after.next;
     }
     ListNode before=after;
     for(int i=a-1;i<b+1;i++){
        before=before.next;
     }
     ListNode temp=list2;
     while(temp.next!=null){
        temp=temp.next;
     }
     after.next=list2;
     temp.next=before;
     return list1;

    }
}