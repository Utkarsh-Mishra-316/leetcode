import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        long totalSubarrays = 0;
        long currentCost = 0;

        // Monotonic decreasing deque storing {value, count_of_elements_forced_to_this_value}
        // Front = left side (near l), Back = right side (near r)
        Deque<long[]> dq = new ArrayDeque<>();

        int r = n - 1;
        for (int l = n - 1; l >= 0; l--) {
            long val = nums[l];
            long count = 1;

            // Merge all blocks to the right whose value is <= nums[l]
            // Because nums[l] is on their left, they must all be raised to nums[l]
            while (!dq.isEmpty() && dq.peekFirst()[0] <= val) {
                long[] front = dq.pollFirst();
                currentCost += (val - front[0]) * front[1];
                count += front[1];
            }
            dq.addFirst(new long[]{val, count});

            // Shrink window from the right (r--) while cost exceeds k
            while (currentCost > k) {
                long[] back = dq.peekLast();
                // The element at index r was raised to back[0]
                currentCost -= (back[0] - nums[r]);
                back[1]--;
                if (back[1] == 0) {
                    dq.pollLast();
                }
                r--;
            }

            // All subarrays starting at l and ending at any index in [l, r] are valid
            totalSubarrays += (r - l + 1);
        }

        return totalSubarrays;
    }
}