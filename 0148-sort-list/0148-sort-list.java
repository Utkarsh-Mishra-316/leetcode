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
    public ListNode sortList(ListNode head) {
 if(head==null || head.next==null) return head;
 ListNode mid=  findmid(head);
 ListNode righthead=mid.next;
 mid.next=null;

  ListNode left=sortList(head);
  ListNode right=sortList(righthead);
  return merge(left,right);


     }
     
     ListNode findmid(ListNode head){
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null &&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
     }
     ListNode merge(ListNode l1,ListNode l2){
        ListNode dummynode=new ListNode(0);
        ListNode curr=dummynode;
        while(l1!=null && l2!=null){
            if(l1.val>l2.val){
                curr.next=l2;
                l2=l2.next;
            }
             else{
                curr.next=l1;
                l1=l1.next;
            }
            curr=curr.next;
        }
        curr.next = (l1 != null) ? l1 : l2;
        return dummynode.next;
     }
     }
 //   brute force
// class Solution {
//     public ListNode sortList(ListNode head) {
//         ListNode temp=head;
//         ArrayList<Integer> arr=new ArrayList<>();
//         while(temp!=null){
//             arr.add(temp.val);
//             temp=temp.next;
//         }
//         Collections.sort(arr);
//         temp=head;
//         int i=0;
//         while(temp!=null){
//             temp.val=arr.get(i);
//             i++;
//             temp=temp.next;
//         }
//     return head;
//     }
// }

