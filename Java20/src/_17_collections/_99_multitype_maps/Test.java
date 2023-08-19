package _17_collections._99_multitype_maps;

import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

public class Test {
    private static final SortedSet<IntegerBucket> sortedSet = new TreeSet<>();

    public static void main(String[] args) {
        sortedSet.add(new IntegerBucket("Winner", 3));
        sortedSet.add(new IntegerBucket("Looser", 3));

        System.out.println("sortedSet has " + sortedSet.size() + " members");
        System.out.println(sortedSet);
    }
}

class IntegerBucket implements Comparable<IntegerBucket> {
    private int value;
    private String name;

    public IntegerBucket(String n, int val) {
        name = n;
        value = val;
    }

    public int getValue() {
        return value;
    }

    // Comparable interface
    public int compareTo(IntegerBucket ob) {
        if (getValue() == ob.getValue()) {
            return name.compareTo(ob.name);
        }
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IntegerBucket that = (IntegerBucket) o;

        if (value != that.value) return false;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        int result = value;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public String toString() {
        return name + " " + getValue();
    }
}