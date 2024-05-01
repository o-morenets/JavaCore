package stackOverflow.bufferedReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Matrix {
    int[][] matrix;

    public Matrix(int rows, int columns) {
        matrix = new int[rows][columns];
    }

    public void set(int row, int column, int value) {
        matrix[row][column] = value;
    }

    public void printSum() {
        int result = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result += matrix[i][j];
            }
        }
        System.out.println("Suma : "+result);
    }

    public void printMatrixTransposed(){
        int [][] transposedMatrix = new int [matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++){
                transposedMatrix [j][i] = matrix[i][j];
            }
        }
        for (int i = 0; i < transposedMatrix.length; i++) {
            System.out.println();
            for (int j = 0; j < transposedMatrix[0].length; j++) {
                System.out.printf("%d ", transposedMatrix[i][j]);
            }
        }
    }


    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter rows :");
            int rows = Integer.parseInt(reader.readLine());
            System.out.println("Enter columns :");
            int colums = Integer.parseInt(reader.readLine());
            Matrix matrix = new Matrix(rows, colums);

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < colums; j++) {
                    System.out.println("Enter : [" + i + "," + j + "]");
                    matrix.set(i, j, Integer.parseInt(reader.readLine()));
                }
            }
            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
