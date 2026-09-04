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
        List<Integer> list=new ArrayList<>();
        ListNode last=head;
        ListNode curr=head.next;
 int cnt=1;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        while(curr.next!=null){
 ListNode Next=curr.next;
            if(curr.val>last.val && curr.val>Next.val){
            list.add(cnt);
         
            }
            else{
                
                if(curr.val<last.val && curr.val<Next.val){
                list.add(cnt);
                }}
                last=curr;
                curr=Next;
                cnt++;
            
        }
 if(list.size()<2){
    return new int[]{-1,-1};
 }
max=list.get(list.size()-1)-list.get(0);
for(int i=1;i<list.size();i++){
    min=Math.min(min,list.get(i)-list.get(i-1));
}
return new int[]{min,max};
    }
}