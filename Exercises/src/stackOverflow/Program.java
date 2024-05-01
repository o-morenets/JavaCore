package stackOverflow;

import java.io.FileInputStream;
import java.io.IOException;

public class Program {
    public static void main(String[] args) {

        try (FileInputStream fin = new FileInputStream("C://SomeDir//notes.txt")) {
            System.out.printf("File size: %d bytes \n", fin.available());

            int i = fin.read();
            while (i != -1) {
                System.out.print((char) i);
                i = fin.read();
            }
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }
}
