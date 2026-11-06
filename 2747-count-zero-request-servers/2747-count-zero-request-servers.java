import java.util.*;

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int m = queries.length;

        // Step 1: Sort logs based on timestamp
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

        // Step 2: Store queries with their original indices and sort them by query time
        int[][] sortedQueries = new int[m][2];
        for (int i = 0; i < m; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));

        int[] ans = new int[m];
        // Server IDs are 1-indexed up to n
        int[] serverCount = new int[n + 1];
        int activeServers = 0;

        int left = 0;
        int right = 0;
        int totalLogs = logs.length;

        // Step 3: Process queries in increasing order of time
        for (int i = 0; i < m; i++) {
            int qTime = sortedQueries[i][0];
            int origIdx = sortedQueries[i][1];

            int windowStart = qTime - x;
            int windowEnd = qTime;

            // Expand window: Add logs that occurred <= windowEnd
            while (right < totalLogs && logs[right][1] <= windowEnd) {
                int sId = logs[right][0];
                if (serverCount[sId] == 0) {
                    activeServers++;
                }
                serverCount[sId]++;
                right++;
            }

            // Shrink window: Remove logs that occurred < windowStart
            while (left < totalLogs && logs[left][1] < windowStart) {
                int sId = logs[left][0];
                serverCount[sId]--;
                if (serverCount[sId] == 0) {
                    activeServers--;
                }
                left++;
            }

            // Number of zero-request servers = total servers - active servers
            ans[origIdx] = n - activeServers;
        }

        return ans;
    }
}