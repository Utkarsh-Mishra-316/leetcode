/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;

        // 2. Current node ka link ab agle ke agle node se jod dein
        // Isse beech wala duplicate node skip ho jayega
        node.next = node.next.next;
    }
}