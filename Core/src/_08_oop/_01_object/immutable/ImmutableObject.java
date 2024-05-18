package _08_oop._01_object.immutable;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 1. Declare the class as final, so it can’t be extended.
 * 2. Make all the fields private and final so that direct access is not allowed.
 * 3. Don’t provide setter methods for variables.
 * 4. Make all mutable fields final so that a field’s value can be assigned only once.
 * 5. Initialize all fields using a constructor method performing deep copy.
 * 6. Perform cloning of objects in the getter methods to return a copy rather than returning the actual object reference.
 */
public final class ImmutableObject {

    private final int number; // primitives are immutable
    private final String name; // String is also immutable

    private final MutableObject mutableObject; // mutable object
    private final List<Integer> integers; // mutable list (add/remove/set/clear are allowed) of immutable objects (Integers)
    private final Map<Long, MutableObject> mutableObjectMap; // mutable collection contains mutable objects

    public ImmutableObject(int number, String name, MutableObject mutableObject, List<Integer> integers, Map<Long, MutableObject> mutableObjectMap) {
        this.number = number;
        this.name = name;

        // Make a deep copy to prevent mutations of initial object from outside
        this.mutableObject = mutableObject.clone();

        // Integers inside List are immutable, but we still can add/remove/set elements changing the state of List
        // So, we store the copy of list, but getter also needs to return a copy (see getter below)
        this.integers = new ArrayList<>(integers);

//        this.mutableObjectMap = Collections.unmodifiableMap(mutableObjectMap); // here, we prevent from changing collection, but not its mutable elements
        this.mutableObjectMap = mutableObjectMap.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().clone()));
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public MutableObject getMutableObject() {
        return mutableObject.clone(); // although we have a copy of object, we need to return a deep copy, so the inner object can not be changed using getter
    }

    public List<Integer> getIntegers() {
        return new ArrayList<>(integers); // although we have a copy of list (see initialization in constructor), we still need to prevent exposing it outside
    }

    public Map<Long, MutableObject> getMutableObjectMap() {
        return mutableObjectMap.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().clone()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImmutableObject that = (ImmutableObject) o;
        return number == that.number && Objects.equals(name, that.name) && Objects.equals(mutableObject, that.mutableObject) && Objects.equals(integers, that.integers) && Objects.equals(mutableObjectMap, that.mutableObjectMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name, mutableObject, integers, mutableObjectMap);
    }
}
