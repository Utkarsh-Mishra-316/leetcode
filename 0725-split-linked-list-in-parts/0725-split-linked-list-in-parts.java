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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode tail=head;
        ListNode[] res=new ListNode[k];
        int total=0;
        while(tail!=null){
            total++;
            tail=tail.next;
        }
        int base=total/k;
        int extra=total%k;
        ListNode curr=head;
        for(int i=0;i<k;i++){
            if(curr==null){
        res[i]=null;
        continue;
            }
            res[i]=curr;
            int cs=base+(extra>0 ?1:0);
            extra--;
            for(int j=1;j<cs;j++){
                curr=curr.next;
            }
            ListNode nexthead=curr.next;
            curr.next=null;
            curr=nexthead;

        }
return res;
    }
}