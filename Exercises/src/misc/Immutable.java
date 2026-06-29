package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public final class Immutable {
    private final String name;
    private final List<String> linkNames;
    private final AtomicBoolean flag;

    public Immutable(String name, List<String> linkNames, AtomicBoolean flag) {
        this.name = name;
        this.linkNames = List.copyOf(linkNames);
        this.flag = new AtomicBoolean(flag.get());
    }

    @Override
    public String toString() {
        return "Immutable{" +
                "name='" + name + '\'' +
                ", linkNames=" + linkNames +
                ", flag=" + flag +
                '}';
    }

    public String getName() {
        return name;
    }

    public List<String> getLinkNames() {
        return linkNames;
    }

    public AtomicBoolean getFlag() {
        return new AtomicBoolean(flag.get());
    }

    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>(Arrays.asList("A", "B", "C"));

        AtomicBoolean aFlag = new AtomicBoolean(false);
        Immutable instance = new Immutable("Test", names, aFlag);
        System.out.println("instance = " + instance);

        names.add("D");
        aFlag.set(true);
//        instance.getFlag().set(true);

        System.out.println("instance = " + instance);
    }
}
