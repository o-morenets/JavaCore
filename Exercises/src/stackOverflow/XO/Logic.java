package stackOverflow.XO;

import java.util.Random;
import java.util.Scanner;

public class Logic {
    protected final int SIZE = 3;
    protected final char DOT_EMPTY = '*';
    protected final char DOT_X = 'X';
    protected final char DOT_O = 'O';
    protected char[][] map;
    protected Scanner scanner = new Scanner(System.in);
    protected Random random = new Random();
    protected int pick1;
    protected int pick2;

    protected void pickPlayer() {
        do {
            System.out.println("Введите '1' что бы играть с человеком");
            System.out.println("Введите '2' что бы играть с AI");
            pick2 = scanner.nextInt();
        } while (pick2 != 1 && pick2 != 2);

        if (pick2 == 2) {
            do {
                System.out.println("Введите '1' что бы начать первым");
                System.out.println("Введите '2' что бы уступить ход");
                pick1 = scanner.nextInt();
            } while (pick1 != 1 && pick1 != 2);
        }
        if (pick2 == 1) {
            pick1 = 1;
        }
    }

    protected void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    protected void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    protected void human() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));
        if (pick1 == 1) {
            map[y][x] = DOT_X;
        } else {
            map[y][x] = DOT_O;
        }
    }

    protected void humanTwo() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));
        if (pick1 == 2) {
            map[y][x] = DOT_X;
        } else {
            map[y][x] = DOT_O;
        }
    }

    protected void AI() {
        int x, y;
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        if (pick1 == 2) {
            map[y][x] = DOT_X;
        } else {
            map[y][x] = DOT_O;
        }
    }

    public boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        return map[y][x] == DOT_EMPTY;
    }

    protected boolean checkWin(char symb) {

        if (map[0][0] == symb && map[0][1] == symb && map[0][2] == symb)
            return true;
        if (map[1][0] == symb && map[1][1] == symb && map[1][2] == symb)
            return true;
        if (map[2][0] == symb && map[2][1] == symb && map[2][2] == symb)
            return true;

        if (map[0][0] == symb && map[1][1] == symb && map[2][2] == symb)
            return true;

        if (map[0][0] == symb && map[1][0] == symb && map[2][0] == symb)
            return true;
        if (map[0][1] == symb && map[1][1] == symb && map[2][1] == symb)
            return true;

        if (map[2][0] == symb && map[1][1] == symb && map[0][2] == symb)
            return true;
        if (map[0][2] == symb && map[1][2] == symb && map[2][2] == symb)
            return true;

        return false;
    }

    protected boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }
}