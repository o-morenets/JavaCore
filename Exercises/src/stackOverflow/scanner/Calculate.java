package stackOverflow.scanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculate {
    public static void main(String[] args) {
        // то, что передаю в сканер
        Calculate c = new Calculate();
        String nn = "12 + 8";
        Scanner sc = new Scanner(nn);
        c.calc(sc);
    }

    void calc(Scanner sc) {
        //Scanner sc = new Scanner(str);
        if (check(sc) == true) {
            //String nn = "12 + 8";
            List<Integer> digits = new ArrayList<Integer>();
            List<Character> signs = new ArrayList<Character>();
            fillLists(sc, digits, signs);
            int result = 0;
            switch(signs.get(0)){
                case '+':
                    result = digits.get(0) + digits.get(1);
                    break;
                case '-':
                    result = digits.get(0) - digits.get(1);
                    break;
                case '*':
                    result = digits.get(0) * digits.get(1);
                    break;
                case '/':
                    result = digits.get(0) / digits.get(1);
                    break;
            }
            System.out.println("Result " + result);
        }
        else {
            System.out.println("Check failed. Throw exception");
        }
    }

    private boolean check(Scanner sc) {
        return true;
    }

    void fillLists(Scanner sc, List digits, List signs) {
        int i = 0;
        while (sc.hasNext()) {
            if (i % 2 == 0)
                digits.add(sc.nextInt());
            else
                signs.add(sc.next().charAt(0));
            i++;
        }
    }
}
