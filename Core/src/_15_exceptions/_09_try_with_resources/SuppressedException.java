package _15_exceptions._09_try_with_resources;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SuppressedException {

    public static void demoSuppressedException(String filePath) throws IOException {
        FileInputStream fileIn = null;
        try {
            fileIn = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            throw new IOException(e); // suppressed
        } finally {
            fileIn.close(); // NPE will be the first
        }
    }

    @Test(expected = NullPointerException.class)
    public void givenNonExistentFileName_whenAttemptFileOpen_thenNullPointerException() throws IOException {
        demoSuppressedException("/non-existent-path/non-existent-file.txt");
    }
}
