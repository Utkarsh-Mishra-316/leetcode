import java.util.*;

class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {

        int n = arrival.length;
        int[] count = new int[k];

        // Available servers
        TreeSet<Integer> free = new TreeSet<>();

        // Busy servers: {finishTime, serverId}
        PriorityQueue<int[]> busy = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        for (int i = 0; i < k; i++) {
            free.add(i);
        }

        for (int i = 0; i < n; i++) {

            int time = arrival[i];

            // Step 1: Release completed servers
            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                int[] server = busy.poll();
                free.add(server[1]);
            }

            // Step 2: If all servers are busy
            if (free.isEmpty()) {
                continue;
            }

            // Step 3: Find preferred server
            int preferred = i % k;

            // First free server >= preferred
            Integer server = free.ceiling(preferred);

            // Circular wrap-around
            if (server == null) {
                server = free.first();
            }

            // Step 4: Assign request
            count[server]++;

            busy.offer(new int[]{
                time + load[i],
                server
            });

            free.remove(server);
        }

        // Step 5: Find maximum handled requests
        int max = 0;

        for (int c : count) {
            max = Math.max(max, c);
        }

        // Step 6: Collect busiest servers
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            if (count[i] == max) {
                ans.add(i);
            }
        }

        return ans;
    }
}