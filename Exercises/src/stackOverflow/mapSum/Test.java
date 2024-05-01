package stackOverflow.mapSum;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.summingInt;

public class Test {
    public static void main(String[] args) {
        List<SomeClass> list = new ArrayList<>();
        list.add(new SomeClass("Someone", 3, 2));
        list.add(new SomeClass("AnotherOne", 4, 6));
        list.add(new SomeClass("Someone", 1, 4));

/*
        Map<String, Integer> someones = list.stream()
                // собираем из листа карту
                .collect(Collectors.toMap(
                        // ключ - строка
                        e -> e.name,
                        // значение - число,
                        // суммируем два поля
                        e -> e.field1 + e.field2,
                        // суммируем значения
                        // повторяющихся элементов
                        Integer::sum,
                        // имплементация карты
                        // с сортировкой элементов
                        // в порядке добавления
                        LinkedHashMap::new));

        System.out.println(someones); // {Someone=10, AnotherOne=10}
*/

        Map<String, Integer> map = list.stream()
                .collect(groupingBy(SomeClass::getName, mapping(SomeClass::getField2, summingInt(Integer::intValue))));

        System.out.println(map);
    }
}

class SomeClass {
    String name;
    int field1;
    int field2;

    public String getName() {
        return this.name;
    }

    public int getField1() {
        return this.field1;
    }

    public int getField2() {
        return this.field2;
    }

    public SomeClass(String name, int field1, int field2) {
        this.name = name;
        this.field1 = field1;
        this.field2 = field2;
    }
}