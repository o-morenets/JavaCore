package stackOverflow.iteratorArray2D;

import java.util.Iterator;

public class MatrixIt implements Iterator<Integer> {

    private int[][] array;
    private int row;
    private int col;

    public MatrixIt(int[][] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Integer next() {
        if (array[row].length == 0) {
            while (array[row].length == 0) {
                row++;
                col = 0;
            }
        }
        Integer result = array[row][col++];
        if (col >= array[row].length) {
            row++;
            col = 0;
        }
        return result;
    }
}