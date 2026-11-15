class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = 1_000_000_007;
        long ans = 0;
        
        int prefixSum = 0;
        int evenCount = 1; // Initial prefix sum 0 is even
        int oddCount = 0;

        for (int num : arr) {
            prefixSum += num;

            if (prefixSum % 2 == 0) {
                // Current prefix sum is even -> pair with previous odd prefix sums
                ans = (ans + oddCount) % MOD;
                evenCount++;
            } else {
                // Current prefix sum is odd -> pair with previous even prefix sums
                ans = (ans + evenCount) % MOD;
                oddCount++;
            }
        }

        return (int) ans;
    }
}