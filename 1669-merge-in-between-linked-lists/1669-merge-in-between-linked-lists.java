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
        ListNode aftera=list1;
        for(int i=0;i<a-1;i++){
            aftera=aftera.next;

        }
        ListNode beforeb=aftera;
        for(int i=a;i<=b+1;i++){
            beforeb=beforeb.next;
        }
        ListNode temp=list2;
        while(temp.next!=null){
            temp=temp.next;
        }
        aftera.next=list2;
        temp.next=beforeb;
return list1;
    }
}