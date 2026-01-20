package leetcode._706_Design_HashMap;

/**
 * 706. Design HashMap
 * Easy
 * Topics
 * premium lock icon
 * Companies
 * Design a HashMap without using any built-in hash table libraries.
 *
 * Implement the MyHashMap class:
 *
 * MyHashMap() initializes the object with an empty map.
 * void put(int key, int value) inserts a (key, value) pair into the HashMap. If the key already exists in the map, update the corresponding value.
 * int get(int key) returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
 * void remove(key) removes the key and its corresponding value if the map contains the mapping for the key.
 *
 *
 * Example 1:
 *
 * Input
 * ["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
 * [[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
 * Output
 * [null, null, null, 1, -1, null, 1, null, -1]
 *
 * Explanation
 * MyHashMap myHashMap = new MyHashMap();
 * myHashMap.put(1, 1); // The map is now [[1,1]]
 * myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
 * myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
 * myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
 * myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
 * myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
 * myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
 * myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]
 *
 *
 * Constraints:
 *
 * 0 <= key, value <= 106
 * At most 104 calls will be made to put, get, and remove.
 */
public class MyHashMap {

    private static final int CAPACITY = 8;
    private final Node[] array;

    public MyHashMap() {
        array = new Node[CAPACITY];
    }

    public void put(int key, int value) {
        int bucket = hash(key);
        Node newNode = new Node(key, value);

        Node current = array[bucket];

        if (current == null) {
            array[bucket] = newNode;
            return;
        }

        while (current != null) {
            if (current.key == key) {
                current.value = value;
                return;
            }
            current = current.next;
        }

        newNode.next = array[bucket];
        array[bucket] = newNode;
    }

    public int get(int key) {
        int bucket = hash(key);
        Node current = array[bucket];

        while (current != null) {
            if (current.key == key) return current.value;
            current = current.next;
        }

        return -1;
    }

    public void remove(int key) {
        int bucket = hash(key);
        Node prev = null;
        Node current = array[bucket];

        while (current != null) {
            if (current.key == key) {
                if (prev == null) array[bucket] = current.next;
                else prev.next = current.next;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    private int hash(int num) {
        return num % CAPACITY;
    }

    private static class Node {

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        int key;
        int value;
        Node next;
    }

    static void main() {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1);                                          // The map is now [[1,1]]
        myHashMap.put(2, 2);                                          // The map is now [[1,1], [2,2]]
        System.out.println("myHashMap.get(1) = " + myHashMap.get(1)); // return 1, The map is now [[1,1], [2,2]]
        System.out.println("myHashMap.get(3) = " + myHashMap.get(3)); // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
        myHashMap.put(2, 1);                                          // The map is now [[1,1], [2,1]] (i.e., update the existing value)
        System.out.println("myHashMap.get(2) = " + myHashMap.get(2)); // return 1, The map is now [[1,1], [2,1]]
        myHashMap.remove(2);                                      // remove the mapping for 2, The map is now [[1,1]]
        System.out.println("myHashMap.get(2) = " + myHashMap.get(2)); // return -1 (i.e., not found), The map is now [[1,1]]
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */