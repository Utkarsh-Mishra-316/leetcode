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
    public ListNode swapNodes(ListNode head, int k) {
        int cnt=0;
        ListNode curr=head;
        while(curr!=null){
            cnt++;
            curr=curr.next;
        }
        int ans=cnt-k+1;
        curr=head;
        for(int i=1;i<ans;i++){
    curr=curr.next;
        }
        ListNode temp=head;
        for(int i=1;i<k;i++){
 temp=temp.next;
        }
        int i=temp.val;
        temp.val=curr.val;
        curr.val=i;
return head;
    }
}