package stackOverflow.ticTacToe;

import java.util.ArrayList;

/**
 * класс игровое поле
 * альтернативное поле предполагается использовать в качестве маркера заполненности основного поля. Т.е. если поставлена метка, space.remove(index)(пока не реализовано)
 */
public class Field {
    char[][] field;                                     //видимое поле 1
    ArrayList<Integer> space;                           //альтернативное внутреннее поле 2

    Field() {
        char[][] field = new char[3][3];                // 1
        this.field = field;
        space = new ArrayList<Integer>(9);  // 2
    }

    void fillTheField() {                               // 1
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.field[i][j] = '.';
            }
        }
    }

    void fillTheSpace() {                                //2
        for (int i = 0; i < 9; i++) {
            space.add(i);
        }
    }


    void printFields() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(this.field[i][j] + "\t\t");
            }
            System.out.println("");
            System.out.println("");
        }
        for (int i = 0; i < 9; i++) {
            System.out.print(space + "\t");
        }
    }

    void markX(int i, int j) {
        this.field[i][j] = 'X';
    }

    void markO(int i, int j) {
        this.field[i][j] = '0';
    }

}
