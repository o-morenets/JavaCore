package _08_oop._01_object.immutable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ImmutableDemo {

    public static void main(String[] args) {

        int number = 17;
        String name = "Test";
        Address address = new Address("UK", 12345);
        MutableObject mutableObject = new MutableObject("str", address);
        List<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Map<Long, MutableObject> mutableObjectMap = Map.of(
                1L, new MutableObject("str1", new Address("country1", 11111)),
                2L, new MutableObject("str2", new Address("country2", 22222)),
                3L, new MutableObject("str3", new Address("country3", 33333))
        );

        ImmutableObject immutableObject = new ImmutableObject(number, name, mutableObject, integers, mutableObjectMap);

        // before changing attributes
        System.out.println("immutableObject.hashCode() = " + immutableObject.hashCode());

        // trying to change mutable dependencies...

        mutableObject.setAddress(null);
        immutableObject.getMutableObject().setStr(null);

        integers.addFirst(31);
        immutableObject.getIntegers().add(123);

        mutableObjectMap.get(2L).setAddress(null);
        immutableObject.getMutableObjectMap().get(3L).setStr(null);

        address.setZipCode(0);
        immutableObject.getMutableObjectMap().get(1L).getAddress().setCountry(null);

        // after changing attributes
        System.out.println("immutableObject.hashCode() = " + immutableObject.hashCode()); // should be the same
    }
}
