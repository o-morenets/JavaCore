package stackOverflow.iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(4, 6, 2, 5, 3, 7, 3, 4, 9, 7, 8, 5));

        // Предпоследний элемент можно удалить без ConcurrentModificationException:
        for (Integer item : list) {
            if (item == 8) {
                list.remove(item);
            }
        }
        System.out.println(list); // [4, 6, 2, 5, 3, 7, 3, 4, 9, 7, 5]

        // Исключения не будет, но и результат неочевидный:
        for (int i = 0; i < list.size(); i++) {
            list.remove(i);
        }
        System.out.println(list); // [6, 5, 7, 4, 7]

        // Правильный способ с очевидным результатом:
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
            iterator.next();
            iterator.remove();
        }
        System.out.println(list); // []
    }

}
