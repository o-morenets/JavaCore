package stackOverflow.hangman;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        char answer = 0;
        do {
            WordGenerator wordGen = new WordGenerator();
            String word = wordGen.generateWord();
            Game game = new Game();
            game.startGame(word);

            do {
                System.out.println("Хотите сыграть ещё раз? +/-");
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                if (!input.isEmpty())
                    answer = input.charAt(0);
            } while (answer != '+' && answer != '-');
        } while (answer == '+');
    }
}