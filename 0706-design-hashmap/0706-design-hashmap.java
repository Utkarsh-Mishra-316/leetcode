class MyHashMap {
    // Inner class to represent each node in the LinkedList
    class Node {
        int key, val;
        Node next;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private final int SIZE = 10000; // Optimal size to reduce collisions
    private Node[] buckets;

    public MyHashMap() {
        buckets = new Node[SIZE];
    }

    private int getHash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int index = getHash(key);
        if (buckets[index] == null) {
            // No entry at this index, create a dummy head node
            buckets[index] = new Node(-1, -1);
        }
        
        Node prev = find(buckets[index], key);
        if (prev.next == null) {
            prev.next = new Node(key, value); // Add new pair
        } else {
            prev.next.val = value; // Key exists, update value
        }
    }

    public int get(int key) {
        int index = getHash(key);
        if (buckets[index] == null) return -1;
        
        Node prev = find(buckets[index], key);
        return prev.next == null ? -1 : prev.next.val;
    }

    public void remove(int key) {
        int index = getHash(key);
        if (buckets[index] == null) return;
        
        Node prev = find(buckets[index], key);
        if (prev.next != null) {
            prev.next = prev.next.next; // Remove node
        }
    }

    // Helper to find the node BEFORE the target key (useful for deletion)
    private Node find(Node bucket, int key) {
        Node curr = bucket, prev = null;
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
}
/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */