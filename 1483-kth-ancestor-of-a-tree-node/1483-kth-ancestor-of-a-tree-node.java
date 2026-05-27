class TreeAncestor {
    // up[i][j] stores the (2^j)-th ancestor of node i
    private int[][] up;
    private int maxPower = 20; // 2^19 is enough for n = 50,000

    public TreeAncestor(int n, int[] parent) {
        up = new int[n][maxPower];
        
        // Base Case: 2^0 (1st) ancestor of any node is its direct parent
        for (int i = 0; i < n; i++) {
            up[i][0] = parent[i];
        }
        
        // Fill the DP / Sparse table top-down
        for (int j = 1; j < maxPower; j++) {
            for (int i = 0; i < n; i++) {
                int immediateAncestor = up[i][j - 1];
                
                if (immediateAncestor == -1) {
                    up[i][j] = -1; // Root se upar kuch nahi hai
                } else {
                    // Binary Lifting Property: 2^j jump = two consecutive 2^(j-1) jumps
                    up[i][j] = up[immediateAncestor][j - 1];
                }
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
        // Look at the binary representation of k
        for (int j = 0; j < maxPower; j++) {
            // Check if the j-th bit of k is set (1)
            if ((k & (1 << j)) != 0) {
                node = up[node][j]; // Take a jump of size 2^j
                
                if (node == -1) return -1; // Out of boundary check
            }
        }
        return node;
    }
}
/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */