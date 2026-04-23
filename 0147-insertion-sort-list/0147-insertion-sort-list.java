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
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // 1. Dummy node sorted list ke liye
        ListNode dummy = new ListNode(0);
        ListNode curr = head; // Yeh hamara 'Red' element hai

        while (curr != null) {
            // Har baar sorted part ko shuru se check karne ke liye pointer
            ListNode prev = dummy;
            
            // Agla unsorted node save karein
            ListNode nextNode = curr.next;

            // 2. Sahi jagah dhundna (Black list mein)
            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }

            // 3. In-place Insertion
            curr.next = prev.next;
            prev.next = curr;

            // 4. Agle unsorted node par jayein
            curr = nextNode;
        }

        return dummy.next;
    }
}