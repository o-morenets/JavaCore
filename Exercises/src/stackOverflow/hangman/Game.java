package stackOverflow.hangman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private int lifes = 5;
    private String secret;
    private List<Character> progress, mistakes;

    public void startGame(String word) {
        secret = word.toLowerCase();
        progress = new ArrayList<>();
        for (int i = 0; i < secret.length(); i++) {
            progress.add('_');
        }
        mistakes = new ArrayList<Character>();
        printProgress();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine().toLowerCase();
            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                System.out.print("Введите букву: ");
                continue;
            }
            char userVariant = input.charAt(0);
            if (mistakes.contains(userVariant) || progress.contains(userVariant)) {
                System.out.println("Эта буква уже была");
                System.out.print("Введите букву: ");
                continue;
            }
            List<Integer> indexes = new ArrayList<>();
            for (int index = secret.indexOf(userVariant); index >= 0; index = secret.indexOf(userVariant, index + 1)) {
                progress.set(index, userVariant);
                indexes.add(index);
            }
            if (indexes.isEmpty()) {
                System.out.print("Неправильно! ");
                mistakes.add(userVariant);
                lifes--;
                if (lifes == 0) {
                    System.out.println("\nВы проиграли...");
                    break;
                }
            } else {
                System.out.print("Правильно! ");
                boolean playerWin = true;
                for (Character letter : progress) {
                    if (!Character.isLetter(letter)) {
                        playerWin = false;
                    }
                }
                if (playerWin) {
                    System.out.println("Вы выйграли!");
                    break;
                }
            }
            printProgress();
        }
        System.out.println("Это было слово: " + secret.toUpperCase());
    }

    private void printProgress() {
        System.out.print("Слово:");
        for (char letter : progress) {
            System.out.print(" " + letter);
        }
        System.out.print("\nЖизни: ");
        for (int i = 0; i < lifes; i++) {
            System.out.print("💙");
        }
        System.out.print("\n\n\nВведите букву: ");
    }
}
