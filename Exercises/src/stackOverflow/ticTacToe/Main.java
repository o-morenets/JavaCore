package stackOverflow.ticTacToe;

import java.util.Scanner;

/**
 * игровой стартер и основной цикл
 */
public class Main {
    Field field;

    public static void main(String[] args) {
        Main start = new Main();
        PlayerManager manager = new PlayerManager();
        manager.addPlayer(start.playerInvitation());

    }

    void runGame() {
        Count count = new Count(0);
        Field plate = new Field();

        plate.fillTheField();               //инициализация поля отображаемого для игроков
        plate.fillTheSpace();               //поле для вычислений
        plate.printFields();


        mainCycle(plate);
    }

    /**
     * Основной цикл игры между 2 пользователями
     */
    void mainCycle(Field plate) {
        do {
//

        } while (field.space.size() != 0);
    }

    /**
     * приглашения пользователя
     */
    String playerInvitation() {
        System.out.println("Введите имя игрока: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        return name;
    }

}