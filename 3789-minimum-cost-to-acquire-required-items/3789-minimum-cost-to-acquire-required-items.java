class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long c1 = cost1;
        long c2 = cost2;
        long cb = costBoth;
        long n1 = need1;
        long n2 = need2;

        // Option 1: Buy only individual items
        long opt1 = n1 * c1 + n2 * c2;

        // Option 2: Buy type 3 for the minimum overlap, then buy remaining individual
        long minOverlap = Math.min(n1, n2);
        long opt2 = minOverlap * cb + (n1 - minOverlap) * c1 + (n2 - minOverlap) * c2;

        // Option 3: Buy type 3 for the maximum requirement (covers both completely)
        long maxRequirement = Math.max(n1, n2);
        long opt3 = maxRequirement * cb;

        return Math.min(opt1, Math.min(opt2, opt3));
    }
}