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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> set=new HashSet<>();
        for(int num: nums){
            set.add(num);
        }
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode curr=head;
        ListNode pre=dummy;
        while(curr!=null){
            if(set.contains(curr.val)){
                pre.next=curr.next;
            }
            else{
                pre=curr;
            }
            curr=curr.next;
        }
        return dummy.next;
    }
}