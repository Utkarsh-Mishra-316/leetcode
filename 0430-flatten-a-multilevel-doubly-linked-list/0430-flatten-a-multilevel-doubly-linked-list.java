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
        
        // Pointer use karke traverse karenge
        Node curr = head;
        
        while (curr != null) {
            // Agar child milta hai
            if (curr.child != null) {
                // 1. Child list ka aakhri (tail) node dhoondo
                Node childTail = curr.child;
                while (childTail.next != null) {
                    childTail = childTail.next;
                }
                
                // 2. Child tail ko curr.next se connect karo
                childTail.next = curr.next;
                if (curr.next != null) {
                    curr.next.prev = childTail;
                }
                
                // 3. Curr.next ko child se connect karo
                curr.next = curr.child;
                curr.child.prev = curr;
                
                // 4. Child pointer ko null karo (Flattening rule)
                curr.child = null;
            }
            // Aage badho
            curr = curr.next;
        }
        
        return head;
    }
}