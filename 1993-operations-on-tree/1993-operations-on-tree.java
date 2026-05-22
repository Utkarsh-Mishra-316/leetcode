class LockingTree {
    int[] parent;
    int[] lockedBy; // Tracks which user locked which node (-1 means unlocked)
    List<List<Integer>> children; // To easily traverse down for descendants

    public LockingTree(int[] parent) {
        this.parent = parent;
        int n = parent.length;
        this.lockedBy = new int[n];
        this.children = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            lockedBy[i] = -1; // Initially all nodes are unlocked
            children.add(new ArrayList<>());
        }
        
        // Build the tree (Adjacency list from parent array)
        for (int i = 1; i < n; i++) {
            children.get(parent[i]).add(i);
        }
    }
    
    public boolean lock(int num, int user) {
        if (lockedBy[num] == -1) { // If unlocked
            lockedBy[num] = user;   // Lock it
            return true;
        }
        return false;
    }
    
    public boolean unlock(int num, int user) {
        if (lockedBy[num] == user) { // If currently locked by the SAME user
            lockedBy[num] = -1;      // Unlock it
            return true;
        }
        return false;
    }
    
    public boolean upgrade(int num, int user) {
        // Condition 1: Node itself must be unlocked
        if (lockedBy[num] != -1) return false;
        
        // Condition 2: No locked ancestors
        int curr = parent[num];
        while (curr != -1) {
            if (lockedBy[curr] != -1) return false; // Found a locked ancestor!
            curr = parent[curr];
        }
        
        // Condition 3: Must have at least one locked descendant
        // We will do a helper check and unlock them simultaneously if valid
        List<Integer> lockedDescendants = new ArrayList<>();
        findLockedDescendants(num, lockedDescendants);
        
        if (lockedDescendants.isEmpty()) {
            return false; // No locked descendants found
        }
        
        // If all conditions passed: Lock the current node
        lockedBy[num] = user;
        
        // And unlock all of its descendants
        for (int child : lockedDescendants) {
            lockedBy[child] = -1;
        }
        
        return true;
    }
    
    // Helper function (DFS) to find all locked descendants
    private void findLockedDescendants(int num, List<Integer> res) {
        for (int child : children.get(num)) {
            if (lockedBy[child] != -1) {
                res.add(child);
            }
            findLockedDescendants(child, res); // Recursive DFS down the tree
        }
    }
}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */