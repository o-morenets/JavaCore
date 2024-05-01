package stackOverflow;

import java.util.*;

public class Shuffle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Количество элементов массива: ");
        int size = 0;
        if (scan.hasNextInt()) {
            size = scan.nextInt();
        }
        scan.nextLine();

        String[] str = new String[size];

        System.out.println("Введите элементы массива: ");

        for (int i = 0; i < size; i++) {
            str[i] = scan.nextLine();
        }

        System.out.println("Введенные элементы массива:");
        for (int i = 0; i < size; i++) {
            System.out.println(" " + str[i]);
        }

        Random rand = new Random();
        List<String> strL = new ArrayList<>(Arrays.asList(str));
        Collections.shuffle(strL, rand);
        System.out.println("Было: " + Arrays.toString(str));
        System.out.println("Стало: " + strL);
    }
}
