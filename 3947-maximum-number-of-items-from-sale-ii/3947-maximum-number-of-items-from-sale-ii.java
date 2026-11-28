import java.util.*;

class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int maxFactor = 0;
        long globalMinPrice = Long.MAX_VALUE;

        for (int[] item : items) {
            maxFactor = Math.max(maxFactor, item[0]);
            globalMinPrice = Math.min(globalMinPrice, item[1]);
        }

        // Count frequency of each factor
        int[] freq = new int[maxFactor + 1];
        for (int[] item : items) {
            freq[item[0]]++;
        }

        // Harmonic sieve: multCount[f] = total items whose factor is divisible by f
        int[] multCount = new int[maxFactor + 1];
        for (int f = 1; f <= maxFactor; f++) {
            if (freq[f] == 0) continue;
            for (int m = f; m <= maxFactor; m += f) {
                multCount[f] += freq[m];
            }
        }

        // Sort items by price ascending so we greedily pick cheapest 2-for-1 slots first
        Arrays.sort(items, (a, b) -> Integer.compare(a[1], b[1]));

        long remBudget = budget;
        long totalItems = 0;
        long threshold = 2L * globalMinPrice;

        for (int[] item : items) {
            int f = item[0];
            long price = item[1];

            // Only buy 2-for-1 slots that cost strictly less than 2 single copies
            if (price >= threshold) break;

            // Number of distinct other items j != i divisible by f
            long slots = multCount[f] - 1;
            if (slots <= 0) continue;

            long canBuy = Math.min(slots, remBudget / price);
            totalItems += canBuy * 2;
            remBudget -= canBuy * price;

            if (remBudget < price) break;
        }

        // Spend all remaining budget on the globally cheapest item (1 item per copy)
        totalItems += remBudget / globalMinPrice;

        return (int) totalItems;
    }
}