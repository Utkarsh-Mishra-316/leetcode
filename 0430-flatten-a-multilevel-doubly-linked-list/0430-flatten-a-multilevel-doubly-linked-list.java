/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if (head == null) return head;

        Node curr = head;
        while (curr != null) {
            // Case 1: Child exists
            if (curr.child != null) {
                // Step 1: Store the original next pointer
                Node nextNode = curr.next;

                // Step 2: Recursively flatten the child list
                Node childHead = flatten(curr.child);

                // Step 3: Connect curr to childHead
                curr.next = childHead;
                childHead.prev = curr;
                curr.child = null; // Important cleanup

                // Step 4: Find the tail of the flattened child list
                Node temp = childHead;
                while (temp.next != null) {
                    temp = temp.next;
                }

                // Step 5: Connect tail to the original next node
                temp.next = nextNode;
                if (nextNode != null) {
                    nextNode.prev = temp;
                }
            }
            // Move to the next node
            curr = curr.next;
        }
        return head;
    }
}