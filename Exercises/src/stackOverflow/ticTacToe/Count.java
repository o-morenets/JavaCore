package stackOverflow.ticTacToe;

/**
 * Класс уникального номера игрока
 */
public class Count {
    int count;

    Count(int zero) {
        count = zero;
    }

    int getNextCount(Count count) {
        this.count++;
        return this.count;
    }

}
