package stackOverflow.arrayIndexOutOfBounds;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Введите 10 чисел!");

        double[] ch = new double[10]; //???????????????????????????????

        System.out.println(ch.length); //я тупой?

        for (int x = 0; x < ch.length; x++) {
            ch[x] = in.nextDouble();
            System.out.println(ch[x]); // я тупой?
        }
        double res = 0;

        for (int i = 0; i < ch.length; i++) { // а это я вообще не проверял
            res += ch[i];
        }

        double res1 = res / ch.length; //тут всё работает. точно.(не точно(точно))

        System.out.printf("Среднее арефмитическое этих чисел равно : %.1f\n", res1); //это ведь так вычисляется?

    }
}
