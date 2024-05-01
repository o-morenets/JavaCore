package stackOverflow.circleTxt;

public class Main {

    public static final int SIDE = 10;
    public static final char STAR = '*';
    public static final char SPACE = ' ';

    /**
     *  **********
     *  ****  ****
     *  ***    ***
     *  **      **
     *  *        *
     *  *        *
     *  **      **
     *  ***    ***
     *  ****  ****
     *  **********
     *
     * @param args ignored
     */
    public static void main(String[] args) {
        int numStars = SIDE / 2;
        int numSpaces = 0;
        int step = 1;

        for (int i = 0; i < SIDE / 2; i++) {
            printSymbols(STAR, numStars);
            printSymbols(SPACE, numSpaces);
            printSymbols(STAR, numStars);
            System.out.println();

            numStars -= step;
            numSpaces = SIDE - numStars * 2;
        }

        step *= -1;

        for (int i = 0; i < SIDE / 2; i++) {
            numStars -= step;
            numSpaces = SIDE - numStars * 2;

            printSymbols(STAR, numStars);
            printSymbols(SPACE, numSpaces);
            printSymbols(STAR, numStars);
            System.out.println();
        }
    }

    private static void printSymbols(char ch, int numStars) {
        for (int i = 0; i < numStars; i++) {
            System.out.print(ch);
        }
    }
}
