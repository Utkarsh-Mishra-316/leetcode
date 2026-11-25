import java.util.*;

class Solution {
    private static final long BASE1 = 911382323L;
    private static final long BASE2 = 972663749L;
    private static final long MOD1 = 1_000_000_007L;
    private static final long MOD2 = 1_000_000_009L;
    private static final long OFFSET = 1_000_000_001L; // Ensures all values are > 0

    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;
        int low = 1, high = n;
        int ans = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (hasUniqueSubarray(nums, mid)) {
                ans = mid;
                high = mid - 1; // Try to find a smaller valid length
            } else {
                low = mid + 1;  // Need a longer subarray to make it unique
            }
        }
        return ans;
    }

    private boolean hasUniqueSubarray(int[] nums, int len) {
        int n = nums.length;
        long h1 = 0, h2 = 0;
        long pow1 = 1, pow2 = 1;

        for (int i = 0; i < len - 1; i++) {
            pow1 = (pow1 * BASE1) % MOD1;
            pow2 = (pow2 * BASE2) % MOD2;
        }

        Map<Long, Integer> freq = new HashMap<>(n - len + 1);

        for (int i = 0; i < n; i++) {
            long val = nums[i] + OFFSET;
            h1 = (h1 * BASE1 + val) % MOD1;
            h2 = (h2 * BASE2 + val) % MOD2;

            if (i >= len - 1) {
                long combinedHash = (h1 << 32) | (h2 & 0xFFFFFFFFL);
                freq.put(combinedHash, freq.getOrDefault(combinedHash, 0) + 1);

                // Remove the outgoing leftmost element of the window
                long outVal = nums[i - len + 1] + OFFSET;
                h1 = (h1 - (outVal * pow1) % MOD1 + MOD1) % MOD1;
                h2 = (h2 - (outVal * pow2) % MOD2 + MOD2) % MOD2;
            }
        }

        for (int count : freq.values()) {
            if (count == 1) return true;
        }
        return false;
    }
}