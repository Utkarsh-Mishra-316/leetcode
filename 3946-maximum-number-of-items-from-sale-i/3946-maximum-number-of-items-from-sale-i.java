import java.util.*;

class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int maxFactor = 0;
        int globalMinPrice = Integer.MAX_VALUE;

        for (int[] item : items) {
            maxFactor = Math.max(maxFactor, item[0]);
            globalMinPrice = Math.min(globalMinPrice, item[1]);
        }

        // 1. Count how many items have each factor value
        int[] freq = new int[maxFactor + 1];
        for (int[] item : items) {
            freq[item[0]]++;
        }

        // 2. For each factor f, count total items whose factor is a multiple of f
        int[] multipleCount = new int[maxFactor + 1];
        for (int f = 1; f <= maxFactor; f++) {
            if (freq[f] > 0) {
                for (int multiple = f; multiple <= maxFactor; multiple += f) {
                    multipleCount[f] += freq[multiple];
                }
            }
        }

        int[] dp = new int[budget + 1];

        // 3. 0/1 Knapsack over EACH item i (0 to n - 1):
        // First purchase of item i gives 1 bought + (multipleCount[f] - 1) free = multipleCount[f]
        for (int[] item : items) {
            int f = item[0];
            int cost = item[1];
            if (cost <= budget) {
                int gain = multipleCount[f];
                for (int b = budget; b >= cost; b--) {
                    dp[b] = Math.max(dp[b], dp[b - cost] + gain);
                }
            }
        }

        // 4. Unbounded Knapsack: Extra copies (no free bonus) using the globally cheapest item
        for (int b = globalMinPrice; b <= budget; b++) {
            dp[b] = Math.max(dp[b], dp[b - globalMinPrice] + 1);
        }

        int ans = 0;
        for (int b = 0; b <= budget; b++) {
            ans = Math.max(ans, dp[b]);
        }
        return ans;
    }
}