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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Ek dummy node banate hain jo result list ki shuruat karegi
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;

        // Loop tab tak chalega jab tak koi bhi list bachi ho ya carry bacha ho
        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            
            int sum = carry + x + y;
            carry = sum / 10; // Naya carry
            
            // Result list mein nayi node jodo
            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            // Pointers ko aage badhao
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummyHead.next; // Dummy ke agle node se asli result shuru hota hai
    }
}