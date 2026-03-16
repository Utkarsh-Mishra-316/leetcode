import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return new int[0];
        
        int[] result = new int[n - k + 1];
        int ri = 0; // Result array index
        
        // Deque to store indices
        Deque<Integer> dq = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            // 1. Remove indices that are out of this window
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }
            
            // 2. Remove elements smaller than the current element from the back
            // (Maintaining monotonic decreasing order)
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }
            
            // 3. Add current element's index
            dq.offerLast(i);
            
            // 4. Start adding to result once we have hit the window size k
            if (i >= k - 1) {
                result[ri++] = nums[dq.peekFirst()];
            }
        }
        
        return result;
    }
}
// class Solution {
//     public int[] maxSlidingWindow(int[] nums, int k) {
//      int n=nums.length;
//      if(n==0) return new int[0];
//      int []result=new int[n-k+1];
//      for(int i=0;i<=n-k;i++){
//         int maxval=nums[i];
//         for(int j=i;j<i+k;j++){
//             maxval=Math.max(maxval,nums[j]);
//         }
//         result[i]=maxval;
//      }
//      return result;
//     }
// }