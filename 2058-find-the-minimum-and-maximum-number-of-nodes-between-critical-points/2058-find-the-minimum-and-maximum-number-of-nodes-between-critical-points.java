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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
       ListNode last=head;
       ListNode curr=head.next;
       List<Integer> criticalPoints=new ArrayList<>();
       int count=1; 
       while(curr.next!=null  ){
                 ListNode next=curr.next;


            if(curr.val>last.val && curr.val>next.val){

                criticalPoints.add(count);
            }
            else{
                if(curr.val<last.val && curr.val<next.val){
                criticalPoints.add(count);
            
            }
 }
            last=curr;
            curr=next;
            count++;

       }
       if(criticalPoints.size()<2){
        return new int[]{-1,-1};
       }
int minDistance = Integer.MAX_VALUE;
        int maxDistance = criticalPoints.get(criticalPoints.size() - 1) - criticalPoints.get(0);

        for (int i = 1; i < criticalPoints.size(); i++) {
            minDistance = Math.min(minDistance, criticalPoints.get(i) - criticalPoints.get(i - 1));
        }

return new int[]{minDistance,maxDistance};
    }
}