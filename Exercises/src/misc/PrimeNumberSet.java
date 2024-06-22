package misc;

public class PrimeNumberSet {

    public static void main(String[] args) {
        System.out.println(solution(2 * 2 * 3, 3 * 3 * 2)); // set(2, 3) == set(3, 2) - true
        System.out.println(solution(14, 15)); // set(2, 7) != set (3,5) - false
    }

    public static boolean solution(int a, int b) {
        if (a < 1 || b < 1) {
            throw new IllegalArgumentException("Both inputs must be an integer greater than 0");
        }
        return calculateInvariant(a) == calculateInvariant(b);
    }

    public static int calculateInvariant(int number) {
        int result = number;
        for (int i = 2; i <= Math.sqrt(result); i++) {
            while (result % (i * i) == 0) {
                result /= i;
            }
        }
        return result;
    }
}
