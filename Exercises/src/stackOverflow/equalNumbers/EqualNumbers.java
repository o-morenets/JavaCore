
package stackOverflow.equalNumbers;

import java.util.*;

public class EqualNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите количество рядков: ");
        int n = in.nextInt();
        in.nextLine();

        for (int k = 0; k < n; k++) {
            String[] strings = new String[n];
            HashSet<String> test = new HashSet<String>();
            System.out.println("\nВведите рядок: ");
            String[] inputArr = in.nextLine().split(" ");

            for (int i = 0; i < inputArr.length; i++) {
                if (Integer.parseInt(inputArr[i]) > 9) {
                    for (int j = i + 1; j < inputArr.length; j++) {
                        if (!inputArr[i].equals(inputArr[j]) && inputArr[i].length() == inputArr[j].length()) {
                            String[] temp1 = inputArr[i].split("");
                            String[] temp2 = inputArr[j].split("");
                            boolean check1 = Arrays.asList(temp1).containsAll(Arrays.asList(temp2));
                            boolean check2 = Arrays.asList(temp2).containsAll(Arrays.asList(temp1));
                            if (check1 && check2) {
                                test.add(inputArr[i] + '-' + inputArr[j]);
                            }
                        }
                    }
                }
            }
            System.out.println("Одинаковые числа: " + test);
        }
    }
}
