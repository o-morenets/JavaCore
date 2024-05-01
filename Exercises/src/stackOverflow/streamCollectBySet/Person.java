package stackOverflow.streamCollectBySet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Person {
    String name;
    Set<Item> items;

    public Person(String name, Set<Item> items) {
        this.name = name;
        this.items = items;
    }

    public String getName() {
        return this.name;
    }

    public Set<Item> getItems() {
        return this.items;
    }
}

class Item {
    String name;

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(this.name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();

        Set<Item> itemsBoughtVasia = new HashSet<>();
        itemsBoughtVasia.add(new Item("Кефир"));
        itemsBoughtVasia.add(new Item("Батон"));
        itemsBoughtVasia.add(new Item("Сок"));
        persons.add(new Person("Василий", itemsBoughtVasia));

        Set<Item> itemsBoughtIvan = new HashSet<>();
        itemsBoughtIvan.add(new Item("Кефир"));
        itemsBoughtIvan.add(new Item("Батон"));
        persons.add(new Person("Иван", itemsBoughtIvan));

        //...

/*
        Map<Item, Long> count = persons.stream()
                .map(person -> {
                    Map<Item, Person> itemPersonMap = new HashMap<>();
                    person.getItems()
                            .forEach(item -> itemPersonMap.put(item, person));
                    return itemPersonMap;
                })
                .flatMap(map -> map.entrySet().stream())
                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.counting()));

        System.out.println(count);
*/

        Map<String, Long> collect = persons.stream()
                .flatMap(person -> person.getItems().stream())
                .collect(Collectors.groupingBy(Item::getName, Collectors.counting()));

        System.out.println(collect);
    }
}