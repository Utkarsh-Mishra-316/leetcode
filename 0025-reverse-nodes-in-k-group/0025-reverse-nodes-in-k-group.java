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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0, head);
        ListNode groupPrev = dummy;

        while (true) {
            // 1. Check karo ki aage k nodes hain ya nahi
            ListNode kth = groupPrev;
            for (int i = 0; i < k && kth != null; i++) {
                kth = kth.next;
            }
            if (kth == null) break; // k se kam nodes bache hain -> ruk jao

            ListNode groupNext = kth.next;

            // 2. k nodes ko reverse karo (prev = groupNext rakhne se tail seedha aage jud jayega)
            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;
            while (curr != groupNext) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            // 3. Pichhle group ko naye head (kth) se jodo aur groupPrev ko aage badhao
            ListNode tail = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = tail;
        }

        return dummy.next;
    }
}