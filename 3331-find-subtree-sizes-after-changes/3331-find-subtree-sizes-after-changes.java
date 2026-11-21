import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private List<Integer>[] origTree;
    private List<Integer>[] newTree;
    private int[] newParent;
    private int[] lastSeen;
    private int[] ans;
    private String s;

    @SuppressWarnings("unchecked")
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        this.s = s;
        this.newParent = parent.clone();
        this.lastSeen = new int[26];
        Arrays.fill(this.lastSeen, -1);

        // Build original tree
        origTree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            origTree[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            origTree[parent[i]].add(i);
        }

        // Pass 1: Find new parent for every node using closest matching ancestor
        dfsFindParents(0);

        // Build new tree after simultaneous re-parenting
        newTree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            newTree[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            newTree[newParent[i]].add(i);
        }

        // Pass 2: Compute subtree sizes in the new tree
        ans = new int[n];
        dfsSubtreeSize(0);

        return ans;
    }

    private void dfsFindParents(int u) {
        int charIdx = s.charAt(u) - 'a';
        int prevAncestor = lastSeen[charIdx];

        if (u != 0 && prevAncestor != -1) {
            newParent[u] = prevAncestor;
        }

        // Update closest ancestor for this character before visiting children
        lastSeen[charIdx] = u;

        for (int v : origTree[u]) {
            dfsFindParents(v);
        }

        // Backtrack: restore previous ancestor when leaving u's subtree
        lastSeen[charIdx] = prevAncestor;
    }

    private int dfsSubtreeSize(int u) {
        int size = 1;
        for (int v : newTree[u]) {
            size += dfsSubtreeSize(v);
        }
        ans[u] = size;
        return size;
    }
}