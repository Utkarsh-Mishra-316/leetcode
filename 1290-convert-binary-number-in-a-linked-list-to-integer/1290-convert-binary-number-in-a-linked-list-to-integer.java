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
    public int getDecimalValue(ListNode head) {
        int result = 0;
        ListNode temp = head;
        
        while (temp != null) {
            // Har step par result ko left shift (x2) karein aur naya bit add karein
            result = (result * 2) + temp.val;
            
            // Pointer ko aage badhayein
            temp = temp.next;
        }
        
        return result;
    }
}