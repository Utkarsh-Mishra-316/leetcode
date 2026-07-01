import java.util.*;

class Solution {
    // 4 directions (Up, Down, Left, Right)
    private final int[] rowDirs = {-1, 1, 0, 0};
    private final int[] colDirs = {0, 0, -1, 1};

    // ✅ FIXED: Method name badal kar 'maximumSafenessFactor' kar diya hai
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        
        // Edge cases
        if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1) {
            return 0;
        }

        int[][] safeness = new int[n][n];
        for (int[] row : safeness) Arrays.fill(row, Integer.MAX_VALUE);
        
        Queue<int[]> queue = new LinkedList<>();

        // 1. Saare thieves ko queue mein daalo Multi-Source BFS ke liye
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid.get(r).get(c) == 1) {
                    queue.offer(new int[]{r, c});
                    safeness[r][c] = 0;
                }
            }
        }

        // Multi-Source BFS
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + rowDirs[i];
                int nc = c + colDirs[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n && safeness[nr][nc] == Integer.MAX_VALUE) {
                    safeness[nr][nc] = safeness[r][c] + 1;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }

        // 2. PriorityQueue (Max-Heap) to find maximum safeness path
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        boolean[][] visited = new boolean[n][n];

        maxHeap.offer(new int[]{safeness[0][0], 0, 0});
        visited[0][0] = true;

        while (!maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll();
            int currSafe = curr[0], r = curr[1], c = curr[2];

            if (r == n - 1 && c == n - 1) {
                return currSafe;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + rowDirs[i];
                int nc = c + colDirs[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    int nextSafe = Math.min(currSafe, safeness[nr][nc]);
                    maxHeap.offer(new int[]{nextSafe, nr, nc});
                }
            }
        }

        return 0;
    }
}