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
        ListNode prevA = list1;
        ListNode afterB = list1;

        // Step 1: Reach index a-1
        for (int i = 0; i < a - 1; i++) {
            prevA = prevA.next;
        }

        // Step 2: Reach index b+1
        for (int i = 0; i < b + 1; i++) {
            afterB = afterB.next;
        }

        // Step 3: Find tail of list2
        ListNode temp2 = list2;
        while (temp2.next != null) {
            temp2 = temp2.next;
        }

        // Step 4: Stitch the lists
        prevA.next = list2;
        temp2.next = afterB;

        return list1;
    }
}