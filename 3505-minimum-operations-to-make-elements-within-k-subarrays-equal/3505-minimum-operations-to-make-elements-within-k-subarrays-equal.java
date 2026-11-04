
class Solution {
    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;

        int[] sorted = nums.clone();
        java.util.Arrays.sort(sorted);

        int m = 0;
        for (int v : sorted) {
            if (m == 0 || sorted[m - 1] != v) {
                sorted[m++] = v;
            }
        }

        int[] vals = java.util.Arrays.copyOf(sorted, m);
        int[] idx = new int[n];

        for (int i = 0; i < n; i++) {
            idx[i] = java.util.Arrays.binarySearch(vals, nums[i]);
        }

        BIT count = new BIT(m);
        BIT sum = new BIT(m);

        int windows = n - x + 1;
        long[] cost = new long[windows];
        long total = 0;

        for (int i = 0; i < x; i++) {
            count.add(idx[i], 1);
            sum.add(idx[i], nums[i]);
            total += nums[i];
        }

        for (int s = 0; s < windows; s++) {
            int midIdx = count.kth((x + 1) / 2);
            long median = vals[midIdx];

            long cntL = count.query(midIdx + 1);
            long sumL = sum.query(midIdx + 1);

            long cntR = x - cntL;
            long sumR = total - sumL;

            cost[s] = median * cntL - sumL
                    + sumR - median * cntR;

            if (s + 1 < windows) {
                count.add(idx[s], -1);
                sum.add(idx[s], -nums[s]);
                total -= nums[s];

                count.add(idx[s + x], 1);
                sum.add(idx[s + x], nums[s + x]);
                total += nums[s + x];
            }
        }

        long INF = Long.MAX_VALUE / 4;
        long[][] dp = new long[k + 1][n + 1];

        for (int j = 1; j <= k; j++) {
            java.util.Arrays.fill(dp[j], INF);
        }

        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
        }

        for (int j = 1; j <= k; j++) {
            for (int i = x; i <= n; i++) {
                dp[j][i] = dp[j][i - 1];

                int start = i - x;
                if (dp[j - 1][start] != INF) {
                    dp[j][i] = Math.min(
                        dp[j][i],
                        dp[j - 1][start] + cost[start]
                    );
                }
            }
        }

        return dp[k][n];
    }

    class BIT {
        int n;
        long[] bit;

        BIT(int n) {
            this.n = n;
            bit = new long[n + 1];
        }

        void add(int i, long val) {
            for (i++; i <= n; i += i & -i) {
                bit[i] += val;
            }
        }

        long query(int i) {
            long ans = 0;
            for (; i > 0; i -= i & -i) {
                ans += bit[i];
            }
            return ans;
        }

        int kth(long k) {
            int idx = 0;
            for (int step = Integer.highestOneBit(n);
                 step > 0; step >>= 1) {
                int next = idx + step;
                if (next <= n && bit[next] < k) {
                    idx = next;
                    k -= bit[next];
                }
            }
            return idx;
        }
    }
}
