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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode curr=head;
       
        int count=1;
        List <Integer> oddp=new ArrayList<>();
        List<Integer> evenp=new ArrayList<>();
        while(curr!=null) {
          if(count%2!=0){
            oddp.add(curr.val);
             
            count++;
          }
          else{
            evenp.add(curr.val);
             
            count++;
          }
          curr=curr.next;
        }
       curr = head;
        
        // Pehle saare ODD values bharo
        for (int val : oddp) {
            curr.val = val;
            if (curr.next != null) {
                curr = curr.next;
            }
        }
        
        // Phir saare EVEN values bharo
        for (int val : evenp) {
            curr.val = val;
            if (curr.next != null) {
                curr = curr.next;
            }
        }

        return head;
    }
}