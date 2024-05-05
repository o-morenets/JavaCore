package _18_collections._04_map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Implementation of Least Recent Used Cache
 * When capacity is reached, least recent used element will be removed after inserting next element
 *
 * @param <K>
 * @param <V>
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {

    private final int capacity;

    public LRUCache(int capacity) {
        super(capacity + 1, 1.1f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return this.size() > capacity;
    }

    public static void main(String[] args) {
        LRUCache<Integer, String> lruCache = new LRUCache<>(2);
        lruCache.put(1, "A");
        lruCache.put(2, "B");
        lruCache.put(3, "C");
        lruCache.get(2);
        lruCache.put(9, "X");

        System.out.println("lruCache = " + lruCache); // lruCache = {2=B, 9=X}
    }
}
