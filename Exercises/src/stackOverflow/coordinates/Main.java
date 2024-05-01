package stackOverflow.coordinates;

import java.util.Scanner;

/**
 * Task: https://informatics.msk.ru/mod/statements/view3.php?chapterid=112169#1
 * so: https://ru.stackoverflow.com/questions/897702/%D0%9F%D0%BE%D0%BF%D0%B0%D0%B4%D0%B0%D0%B5%D1%82-%D0%BB%D0%B8-%D1%82%D0%BE%D1%87%D0%BA%D0%B0-%D0%B2-%D0%B7%D0%B0%D1%88%D1%82%D1%80%D0%B8%D1%85%D0%BE%D0%B2%D0%B0%D0%BD%D0%BD%D1%83%D1%8E-%D0%BE%D0%B1%D0%BB%D0%B0%D1%81%D1%82%D1%8C
 */
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        double x = scan.nextDouble ();
        double y = scan.nextDouble ();

        boolean insideTheShadedArea;

        boolean insideCircle = x * x + y * y <= 1;
        boolean onTheLeft  = x <= 0;
        boolean onTopFunctionYequalsX = y >= x;

        insideTheShadedArea = insideCircle && (onTheLeft || onTopFunctionYequalsX);

        System.out.println(insideTheShadedArea ? "YES" : "NO");
    }
}
