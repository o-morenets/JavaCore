package _18_collections._04_map;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashExample {

    public static void main(String[] args) {
        Map<Key, String> map = getMapNoEqualsNoHashCode(100, 3.14f, "ABC");
        System.out.println("map.size() = " + map.size()); // 3
        System.out.println("Found element: " + map.get(new Key(100, 3.14f, "ABC"))); // null

        Map<KeyHashCodeOnly, String> mapHashCodeOnly = getMapHashCodeOnly(100, 3.14f, "ABC");
        System.out.println("mapHashCodeOnly.size() = " + mapHashCodeOnly.size()); // 3
        System.out.println("Found element: " + mapHashCodeOnly.get(new KeyHashCodeOnly(100, 3.14f, "ABC"))); // null

        Map<KeyEqualsOnly, String> mapEqualsOnly = getMapEqualsOnly(100, 3.14f, "ABC");
        System.out.println("mapEqualsOnly.size() = " + mapEqualsOnly.size()); // some large number
        System.out.println("Found element: " + mapEqualsOnly.get(new KeyEqualsOnly(100, 3.14f, "ABC"))); // null
    }

    private static Map<Key, String> getMapNoEqualsNoHashCode(int i, float f, String s) {
        Map<Key, String> map = new HashMap<>();

        // hashCode will be different as hashCode() method is not overridden
        Key key1 = new Key(i, f, s);
        Key key2 = new Key(i, f, s);
        Key key3 = new Key(i, f, s);

        // every object is considered as distinct as equals() method was not overridden
        map.put(key1, "First");
        map.put(key2, "Second");
        map.put(key3, "Third");

        return map;
    }

    private static Map<KeyHashCodeOnly, String> getMapHashCodeOnly(int i, float f, String s) {
        Map<KeyHashCodeOnly, String> map = new HashMap<>();

        // hashCode will be the same as hashCode() method is overridden
        KeyHashCodeOnly keyHashCodeOnly1 = new KeyHashCodeOnly(i, f, s);
        KeyHashCodeOnly keyHashCodeOnly2 = new KeyHashCodeOnly(i, f, s);
        KeyHashCodeOnly keyHashCodeOnly3 = new KeyHashCodeOnly(i, f, s);

        // every object is considered as distinct as equals() method was not overridden
        map.put(keyHashCodeOnly1, "First");
        map.put(keyHashCodeOnly2, "Second");
        map.put(keyHashCodeOnly3, "Third");

        return map;
    }

    private static Map<KeyEqualsOnly, String> getMapEqualsOnly(int i, float f, String s) {
        Map<KeyEqualsOnly, String> map = new HashMap<>();

        // every object is considered as the same object as equals() method was overridden
        // but these objects may pass into different buckets, so we need to wait for collision
        String value;
        long cnt = 0;
        do {
            // hashCode will be different as hashCode() method is not overridden
            KeyEqualsOnly key = new KeyEqualsOnly(i, f, s);
            value = map.put(key, "Cnt_" + cnt++);
        } while (value == null);

        return map;
    }
}

class Key {
    private int id;
    private float f;
    private String s;

    public Key(int id, float f, String s) {
        this.id = id;
        this.f = f;
        this.s = s;
    }
}

class KeyHashCodeOnly {
    private int id;
    private float f;
    private String s;

    public KeyHashCodeOnly(int id, float f, String s) {
        this.id = id;
        this.f = f;
        this.s = s;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, f, s);
    }
}

class KeyEqualsOnly {
    private int id;
    private float f;
    private String s;

    public KeyEqualsOnly(int id, float f, String s) {
        this.id = id;
        this.f = f;
        this.s = s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeyEqualsOnly that = (KeyEqualsOnly) o;
        return id == that.id && Float.compare(f, that.f) == 0 && Objects.equals(s, that.s);
    }
}