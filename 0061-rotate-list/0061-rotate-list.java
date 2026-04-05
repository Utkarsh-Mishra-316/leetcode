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
    public ListNode rotateRight(ListNode head, int k) {
        // 1. Edge Cases: Empty list or single node
        if (head == null || head.next == null || k == 0) return head;

        // 2. Calculate Length and reach the Tail
        ListNode tail = head;
        int n = 1; 
        while (tail.next != null) {
            tail = tail.next;
            n++;
        }

        // 3. Effective rotation (handle k > n)
        k = k % n;
        if (k == 0) return head; // No rotation needed

        // 4. Make the list Circular
        tail.next = head;

        // 5. Find the new tail: Position (n - k) from head
        ListNode newTail = head;
        for (int i = 0; i < n - k - 1; i++) {
            newTail = newTail.next;
        }

        // 6. Break the circle and set new head
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}