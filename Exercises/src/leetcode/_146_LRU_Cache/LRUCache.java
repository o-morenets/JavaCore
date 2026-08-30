package leetcode._146_LRU_Cache;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU Cache
 * Medium
 * Topics
 * premium lock icon
 * Companies
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 * <p>
 * Implement the LRUCache class:
 * <p>
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * Output
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * <p>
 * Explanation
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // cache is {1=1}
 * lRUCache.put(2, 2); // cache is {1=1, 2=2}
 * lRUCache.get(1);    // return 1
 * lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
 * lRUCache.get(2);    // returns -1 (not found)
 * lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
 * lRUCache.get(1);    // return -1 (not found)
 * lRUCache.get(3);    // return 3
 * lRUCache.get(4);    // return 4
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= capacity <= 3000
 * 0 <= key <= 104
 * 0 <= value <= 105
 * At most 2 * 105 calls will be made to get and put.
 */
class LRUCache {

    int capacity;
    Map<Integer, Node> cache = new HashMap<>();
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        removeNode(node);
        addToEnd(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);

        if (node != null) {
            node.value = value;
            removeNode(node);
            addToEnd(node);
            return;
        }

        evict();

        node = new Node(key, value);
        cache.put(key, node);
        addToEnd(node);
    }

    private void evict() {
        if (cache.size() == capacity) {
            cache.remove(head.next.key);
            removeNode(head.next);
        }
    }

    private void removeNode(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private void addToEnd(Node node) {
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
    }

    private static class Node {
        int key;
        int value;

        Node next;
        Node prev;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);

//        lRUCache.put(1, 1); // cache is {1=1}
//        lRUCache.put(2, 2); // cache is {1=1, 2=2}
//        System.out.println("lRUCache.get(1) = " + lRUCache.get(1));    // return 1
//        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
//        System.out.println("lRUCache.get(2) = " + lRUCache.get(2));    // returns -1 (not found)
//        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
//        System.out.println("lRUCache.get(1) = " + lRUCache.get(1));    // return -1 (not found)
//        System.out.println("lRUCache.get(3) = " + lRUCache.get(3));    // return 3
//        System.out.println("lRUCache.get(4) = " + lRUCache.get(4));    // return 4

//        System.out.println("lRUCache.get(2) = " + lRUCache.get(2));    // return -1
//        lRUCache.put(2, 6);
//        System.out.println("lRUCache.get(1) = " + lRUCache.get(1));    // return -1
//        lRUCache.put(1, 5);
//        lRUCache.put(1, 2);
//        System.out.println("lRUCache.get(1) = " + lRUCache.get(1));    // return 2
//        System.out.println("lRUCache.get(2) = " + lRUCache.get(2));    // return 6

        lRUCache.put(2, 1);
        lRUCache.put(1, 1);
        lRUCache.put(2, 3);
        lRUCache.put(4, 1);
        System.out.println("lRUCache.get(1) = " + lRUCache.get(1));    // return -1
        System.out.println("lRUCache.get(2) = " + lRUCache.get(2));    // return 3
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */