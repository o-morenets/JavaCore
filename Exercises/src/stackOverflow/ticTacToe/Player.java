package stackOverflow.ticTacToe;

import java.util.Scanner;

/**
 * класс игрока
 */
public class Player {
    Count count;
    Field field;
    String name;
    static int id = 0;
    Scanner scanner;
    int[] coords;

    /**
     * Имя, номер пользователя
     */

    Player() {
        id = count.getNextCount(count);
    }

    Player(String name) {
        this();
        this.name = name;
    }

    /**
     * рисование метки от пользователя
     */
    void madeTheMark(Player player, Field field, int[] coords) {
        if (player.id == 1) {
            field.markX(coords[0], coords[1]);
        } else {
            field.markO(coords[0], coords[1]);
        }
    }

    /**
     * метод создания пары координат от пользователя
     */

    int[] getCellCoords() {
        scanner = new Scanner(System.in);
        System.out.println("Введите позицию по горизонтали(от 0 до 2):");
        int i = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Введите позицию по вертикали(от 0 до 2):");
        int j = scanner.nextInt();
        scanner.nextLine();
        int[] coords = new int[2];
        coords[0] = i;
        coords[1] = j;
        this.coords = coords;
        return this.coords;
    }

}
