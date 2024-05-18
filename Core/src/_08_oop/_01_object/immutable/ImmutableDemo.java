package _08_oop._01_object.immutable;

import java.util.*;

public class ImmutableDemo {

    public static void main(String[] args) {

        int number = 17;
        String name = "Test";
        Address address = new Address("UK", 12345);
        MutableObject mutableObject = new MutableObject("str", address);
        List<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Map<Long, MutableObject> mutableObjectMap = new TreeMap<>(
                Map.of(
                        1L, new MutableObject("str1", new Address("country1", 11111)),
                        2L, new MutableObject("str2", new Address("country2", 22222)),
                        3L, new MutableObject("str3", new Address("country3", 33333))
                )
        );

        ImmutableObject immutableObject = new ImmutableObject(number, name, mutableObject, integers, mutableObjectMap);

        // before changing attributes
        System.out.println("INITIAL immutableObject.hashCode() = " + immutableObject.hashCode());

        // trying to change mutable dependencies...

        System.out.println("Initial address: " + address);
        System.out.println("Changing initial address...");
        address.setCountry("PL");
        address.setZipCode(87654);
        System.out.println("Changed address: " + address);
        System.out.println("immutableObject.hashCode() = " + immutableObject.hashCode());

        System.out.println("--------------------------------------");

        System.out.println("Initial mutableObject: " + mutableObject);
        System.out.println("Changing mutableObject's Address...");
        mutableObject.getAddress().setCountry("USA");
        mutableObject.getAddress().setZipCode(-1);
        System.out.println("Changed mutableObject's Address: " + mutableObject);
        System.out.println("immutableObject.hashCode() = " + immutableObject.hashCode());
        System.out.println("Changing mutableObject setting fields to other values...");
        mutableObject.setStr("other");
        mutableObject.setAddress(new Address("Brazil", 321));
        System.out.println("Changed mutableObject: " + mutableObject);
        System.out.println("immutableObject.hashCode() = " + immutableObject.hashCode());

        System.out.println("--------------------------------------");

        MutableObject mutableObjectFromGetter = immutableObject.getMutableObject();
        System.out.println("mutableObjectFromGetter: " + mutableObjectFromGetter);
        System.out.println("Changing mutableObjectFromGetter's Address...");
        mutableObjectFromGetter.getAddress().setCountry("USA");
        mutableObjectFromGetter.getAddress().setZipCode(-1);
        System.out.println("Changed mutableObjectFromGetter's Address: " + mutableObjectFromGetter);
        System.out.println("immutableObject.hashCode() = " + immutableObject.hashCode());
        System.out.println("Changing mutableObjectFromGetter setting fields to other values...");
        mutableObjectFromGetter.setStr("ABCDE");
        mutableObjectFromGetter.setAddress(new Address("Rwanda", 999));
        System.out.println("Changed mutableObjectFromGetter: " + mutableObjectFromGetter);
        System.out.println("mutableObject == mutableObjectFromGetter? " + (mutableObject == mutableObjectFromGetter));
        System.out.println("immutableObject.hashCode() = " + immutableObject.hashCode());

        System.out.println("--------------------------------------");

        System.out.println("Initial integers: " + integers);
        System.out.println("Changing integers (add/set/remove)...");
        integers.addFirst(31);
        integers.set(1, 99);
        integers.remove(4);
        System.out.println("Changed integers: " + integers);
        System.out.println("immutableObject.hashCode() = " + immutableObject.hashCode());

        System.out.println("--------------------------------------");

        List<Integer> integersFromGetter = immutableObject.getIntegers();
        System.out.println("Initial integersFromGetter: " + integersFromGetter);
        System.out.println("Changing integersFromGetter (add/set/remove)...");
        integersFromGetter.remove(1);
        integersFromGetter.add(123);
        integersFromGetter.set(0, 42);
        System.out.println("Changed integersFromGetter: " + integersFromGetter);
        System.out.println("integers == integersFromGetter? " + (integers == integersFromGetter));
        System.out.println("immutableObject.hashCode() = " + immutableObject.hashCode());

        System.out.println("--------------------------------------");

        System.out.println("Initial mutableObjectMap: " + mutableObjectMap);
        System.out.println("Changing mutableObjectMap -> address...");
        mutableObjectMap.get(1L).getAddress().setCountry(null);
        mutableObjectMap.get(3L).getAddress().setZipCode(null);
        System.out.println("Changed mutableObjectMap: " + mutableObjectMap);
        System.out.println("immutableObject.hashCode() = " + immutableObject.hashCode()); // should be the same

        System.out.println("Changing mutableObjectMap's fields...");
        immutableObject.getMutableObjectMap().get(3L).setStr(null);
        immutableObject.getMutableObjectMap().get(3L).setAddress(new Address("Finland", 777));
        System.out.println("Changed mutableObjectMap: " + mutableObjectMap);
        System.out.println("immutableObject.hashCode() = " + immutableObject.hashCode()); // should be the same

        System.out.println("--------------------------------------");

        Map<Long, MutableObject> mutableObjectMapFromGetter = immutableObject.getMutableObjectMap();
        System.out.println("mutableObjectMapFromGetter: " + mutableObjectMapFromGetter);
        System.out.println("Changing mutableObjectMapFromGetter -> address...");
        mutableObjectMapFromGetter.get(1L).getAddress().setCountry(null);
        mutableObjectMapFromGetter.get(1L).getAddress().setZipCode(null);
        System.out.println("Changed mutableObjectMapFromGetter: " + mutableObjectMapFromGetter);
        System.out.println("immutableObject.hashCode() = " + immutableObject.hashCode()); // should be the same

        System.out.println("Changing mutableObjectMapFromGetter's fields...");
        mutableObjectMapFromGetter.get(3L).setStr(null);
        mutableObjectMapFromGetter.get(3L).setAddress(new Address("Finland", 777));
        System.out.println("Changed mutableObjectMapFromGetter: " + mutableObjectMapFromGetter);
        System.out.println("immutableObject.hashCode() = " + immutableObject.hashCode()); // should be the same

        System.out.println("--------------------------------------");

        // after changing attributes
        System.out.println("FINAL immutableObject.hashCode() = " + immutableObject.hashCode()); // should be the same
    }
}
