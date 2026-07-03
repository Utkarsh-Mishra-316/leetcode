import java.util.*;

class Solution {
    // Edge structure to hold destination and recovery cost
    class Edge {
        int to;
        long cost;
        Edge(int to, long cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    // Node structure for PriorityQueue in Dijkstra
    class Node {
        int id;
        long dist;
        Node(int id, long dist) {
            this.id = id;
            this.dist = dist;
        }
    }

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        long maxEdgeCost = 0;
        long minEdgeCost = Long.MAX_VALUE;

        // 1. Graph building (Sirf unhi edges ko rakho jiske dono ends online hain)
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            long cost = edge[2];

            if (online[u] && online[v]) {
                adj.get(u).add(new Edge(v, cost));
                maxEdgeCost = Math.max(maxEdgeCost, cost);
                minEdgeCost = Math.min(minEdgeCost, cost);
            }
        }

        // Agar graph khali hai ya base condition check fail ho jaye
        if (minEdgeCost == Long.MAX_VALUE) return -1;

        long low = minEdgeCost;
        long high = maxEdgeCost;
        long ans = -1;

        // 2. Binary Search over the possible edge weights
        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (canReach(adj, n, mid, k)) {
                ans = mid;    // Agar path valid hai, toh aur bada answer dhoodho
                low = mid + 1;
            } else {
                high = mid - 1; // Agar path nahi mila, toh requirement choti karo
            }
        }

        return (int) ans;
    }

    // 3. Dijkstra validation function to check path with total cost <= k
    private boolean canReach(List<List<Edge>> adj, int n, long minRequiredCost, long maxAllowedTotalCost) {
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));
        pq.offer(new Node(0, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int u = curr.id;
            long d = curr.dist;

            if (d > dist[u]) continue;
            if (u == n - 1) return true; // Destination reached inside cost constraint

            for (Edge edge : adj.get(u)) {
                // FILTER: Agar edge cost candidate minimum threshold se choti hai, skip it!
                if (edge.cost < minRequiredCost) continue;

                if (dist[u] + edge.cost < dist[edge.to]) {
                    dist[edge.to] = dist[u] + edge.cost;
                    // Check if total accumulated cost is within limit before offering
                    if (dist[edge.to] <= maxAllowedTotalCost) {
                        pq.offer(new Node(edge.to, dist[edge.to]));
                    }
                }
            }
        }

        return dist[n - 1] <= maxAllowedTotalCost;
    }
}
