package stackOverflow.scannerNextInt;

import java.util.Arrays;
import java.util.Scanner;

public class ScannerNextInt {

    public static void main(String[] args) {
        int powyk1 = 6;

        Scanner sc = new Scanner(System.in);
//        String scString2 = sc.nextLine();
//        String[] scStrings2 = scString2.split(" ");
        int[] scNumbers2 = new int[powyk1];

        for (int i = 0; i < powyk1; i++) {
            int num = sc.nextInt();
            if (num > 0 && num < Math.pow(10, 9) + 7)
                scNumbers2[i] = num;
        }

        System.out.println(Arrays.toString(scNumbers2));
    }
}
