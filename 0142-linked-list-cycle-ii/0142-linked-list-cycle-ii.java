/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
// public class Solution {
//     public ListNode detectCycle(ListNode head) {
//         ListNode fast=head;
//         ListNode slow=head;

//         int count=0;
//         while(fast.next!=null && fast!=null){
//             fast=fast.next.next;
//             slow=slow.next;
//             count++;
//             if(fast.next==slow.next) return count;
//         }
//         return false;
//     }
// }
 public class Solution {
    public ListNode detectCycle(ListNode head) {
        // Step 1: Pointers initialize karein
        ListNode slow = head;
        ListNode fast = head;

        // Step 2: Cycle detect karein
        while (fast != null && fast.next != null) {
            slow = slow.next;         // 1 step aage
            fast = fast.next.next;    // 2 steps aage

            if (slow == fast) {       // Meeting point mil gaya
                // Step 3: Cycle ka start node dhoondhein
                ListNode entry = head; 
                while (entry != slow) {
                    entry = entry.next;
                    slow = slow.next;
                }
                return entry;         // Jahan dono mile, wahi start node hai
            }
        }

        return null; // Loop se bahar aaye matlab cycle nahi hai
    }
}

    // ListNode fast = head;
    // ListNode slow = head;

    // while (fast != null && fast.next != null) {
    //     fast = fast.next.next; // Hare (2 steps)
    //     slow = slow.next;      // Tortoise (1 step)

    //     // 1. Cycle Mil Gayi!
    //     if (fast == slow) {
    //         int count = 0;
    //         ListNode temp = slow;
            
    //         // 2. Cycle ke andar ek chakkar lagao length ginne ke liye
    //         do {
    //             temp = temp.next;
    //             count++;
    //         } while (temp != slow); // Jab tak wapas wahi na aa jaye
            
    //         return count;
    //     }
    // }
    
    // return 0; // Agar cycle nahi hai toh length 0
