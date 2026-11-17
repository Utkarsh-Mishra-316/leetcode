import java.util.*;

class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        char[] arr = s.toCharArray();

        // Precompute proper divisors for every possible substring length L (2..n)
        List<Integer>[] divisors = new ArrayList[n + 1];
        for (int len = 2; len <= n; len++) {
            divisors[len] = new ArrayList<>();
            for (int d = 1; d * d <= len; d++) {
                if (len % d == 0) {
                    if (d < len) divisors[len].add(d);
                    int other = len / d;
                    if (other != d && other < len) divisors[len].add(other);
                }
            }
        }

        // cost[i][j] = min changes to make s[i..j] a semi-palindrome
        int INF = 1_000_000;
        int[][] cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(cost[i], INF);
            for (int j = i + 1; j < n; j++) {
                cost[i][j] = computeCost(arr, i, j, divisors[j - i + 1]);
            }
        }

        // dp[i][parts] = min changes for prefix s[0..i-1] split into 'parts' substrings
        int[][] dp = new int[n + 1][k + 1];
        for (int[] row : dp) Arrays.fill(row, INF);
        dp[0][0] = 0;

        for (int parts = 1; parts <= k; parts++) {
            // Each part needs at least 2 chars, so i >= 2 * parts
            for (int i = 2 * parts; i <= n; i++) {
                for (int prev = 2 * (parts - 1); prev <= i - 2; prev++) {
                    if (dp[prev][parts - 1] != INF) {
                        dp[i][parts] = Math.min(dp[i][parts], dp[prev][parts - 1] + cost[prev][i - 1]);
                    }
                }
            }
        }

        return dp[n][k];
    }

    private int computeCost(char[] arr, int start, int end, List<Integer> divs) {
        int len = end - start + 1;
        int minChanges = Integer.MAX_VALUE;

        for (int d : divs) {
            int changes = 0;
            int groupLen = len / d;
            // Check each of the 'd' interleaved subsequences
            for (int rem = 0; rem < d; rem++) {
                int l = start + rem;
                int r = start + rem + (groupLen - 1) * d;
                while (l < r) {
                    if (arr[l] != arr[r]) changes++;
                    l += d;
                    r -= d;
                }
            }
            minChanges = Math.min(minChanges, changes);
        }

        return minChanges;
    }
}