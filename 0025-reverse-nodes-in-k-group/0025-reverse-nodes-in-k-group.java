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
        ListNode temp = head;
        ListNode prevLast = null;

        while (temp != null) {
            // 1. Get the k-th node
            ListNode kThNode = getKthNode(temp, k);

            // 2. If k-th node is null, we don't have a full group of size k
            if (kThNode == null) {
                if (prevLast != null) prevLast.next = temp;
                break;
            }

            // 3. Preserve the next group's starting node
            ListNode nextNode = kThNode.next;
            kThNode.next = null; // Break the link to reverse only this group

            // 4. Reverse the segment
            reverse(temp);

            // 5. Connect segments
            if (temp == head) {
                head = kThNode; // Update main head for the first group
            } else {
                prevLast.next = kThNode; // Connect previous segment to new head of current segment
            }

            prevLast = temp; // Current segment's original head is now its tail
            temp = nextNode; // Move to next group
        }
        return head;
    }

    private ListNode getKthNode(ListNode temp, int k) {
        k -= 1;
        while (temp != null && k > 0) {
            k--;
            temp = temp.next;
        }
        return temp;
    }

    private void reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }
}