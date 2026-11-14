class MyHashMap {
    // Define a helper node class for chaining
    private static class Node {
        int key, value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private final int NUM_BUCKETS = 769; // A prime number reduces collisions
    private Node[] buckets;

    public MyHashMap() {
        buckets = new Node[NUM_BUCKETS];
    }
    
    private int hash(int key) {
        return key % NUM_BUCKETS;
    }
    
    public void put(int key, int value) {
        int index = hash(key);
        if (buckets[index] == null) {
            buckets[index] = new Node(key, value);
            return;
        }

        Node curr = buckets[index];
        while (true) {
            if (curr.key == key) {
                curr.value = value; // Update existing key
                return;
            }
            if (curr.next == null) break;
            curr = curr.next;
        }
        curr.next = new Node(key, value); // Append new node if not found
    }
    
    public int get(int key) {
        int index = hash(key);
        Node curr = buckets[index];
        while (curr != null) {
            if (curr.key == key) return curr.value;
            curr = curr.next;
        }
        return -1; // Not found
    }
    
    public void remove(int key) {
        int index = hash(key);
        Node curr = buckets[index];
        if (curr == null) return;

        // If the head is the node to remove
        if (curr.key == key) {
            buckets[index] = curr.next;
            return;
        }

        while (curr.next != null) {
            if (curr.next.key == key) {
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }
}