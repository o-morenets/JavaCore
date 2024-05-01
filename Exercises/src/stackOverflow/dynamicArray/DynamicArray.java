package stackOverflow.dynamicArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DynamicArray<T> {
    /*private*/ T[] array;

    public DynamicArray() {
    }

    public void add(T el) {
        List<T> list = new ArrayList<>();
        list.add(el);
        array = (T[]) list.toArray();
    }

    public static void main(String[] args) {
        DynamicArray<String> stringDynamicArray = new DynamicArray<>();
        stringDynamicArray.add("qwe");

        System.out.println(Arrays.toString(stringDynamicArray.array));
    }
}
