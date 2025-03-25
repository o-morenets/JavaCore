package leetcode._705_Design_HashSet;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * 705. Design HashSet
 * Solved
 * Easy
 * Topics
 * Companies
 * Design a HashSet without using any built-in hash table libraries.
 *
 * Implement MyHashSet class:
 *
 * void add(key) Inserts the value key into the HashSet.
 * bool contains(key) Returns whether the value key exists in the HashSet or not.
 * void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.
 *
 *
 * Example 1:
 *
 * Input
 * ["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
 * [[], [1], [2], [1], [3], [2], [2], [2], [2]]
 * Output
 * [null, null, null, true, false, null, true, null, false]
 *
 * Explanation
 * MyHashSet myHashSet = new MyHashSet();
 * myHashSet.add(1);      // set = [1]
 * myHashSet.add(2);      // set = [1, 2]
 * myHashSet.contains(1); // return True
 * myHashSet.contains(3); // return False, (not found)
 * myHashSet.add(2);      // set = [1, 2]
 * myHashSet.contains(2); // return True
 * myHashSet.remove(2);   // set = [1]
 * myHashSet.contains(2); // return False, (already removed)
 *
 *
 * Constraints:
 *
 * 0 <= key <= 106
 * At most 104 calls will be made to add, remove, and contains.
 */
class MyHashSet {

    private static final int CAPACITY = 10_000;
    private List<Integer>[] data;

    public MyHashSet() {
        this.data = new LinkedList[CAPACITY];
    }

    public void add(int key) {
        var bucket = getBucket(key);
        if (bucket == null) {
            bucket = new LinkedList<>();
            data[getIndex(key)] = bucket;
        }
        if (!bucket.contains(key)) {
            bucket.add(key);
        }
    }

    public void remove(int key) {
        var bucket = getBucket(key);
        if (bucket != null && !bucket.isEmpty()) {
            bucket.remove((Integer) key);
        }
    }

    public boolean contains(int key) {
        var bucket = getBucket(key);
        return bucket != null && bucket.contains(key);
    }

    private int getIndex(int key) {
        return Objects.hash(key) % CAPACITY;
    }

    private List<Integer> getBucket(int key) {
        return data[getIndex(key)];
    }
}

public class Main {
    public static void main(String[] args) {
        MyHashSet obj = new MyHashSet();
        obj.add(1);
        obj.add(2);
        System.out.println(obj.contains(1)); // true
        System.out.println(obj.contains(3)); // false
        obj.add(2);
        System.out.println(obj.contains(2)); // true
        obj.remove(2);
        System.out.println(obj.contains(2)); // false
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */