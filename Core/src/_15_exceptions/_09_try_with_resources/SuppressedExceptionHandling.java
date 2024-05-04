package _15_exceptions._09_try_with_resources;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertEquals;

public class SuppressedExceptionHandling {

    public static void demoAddSuppressedException(String filePath) throws IOException {
        Throwable firstException = null;
        FileInputStream fileIn = null;
        try {
            fileIn = new FileInputStream(filePath);
        } catch (IOException e) {
            firstException = e;
        } finally {
            try {
                fileIn.close();
            } catch (NullPointerException npe) {
                if (firstException != null) {
                    npe.addSuppressed(firstException);
                }
                throw npe;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        demoAddSuppressedException("sdgfsd");
    }

    @Test
    public void givenNonExistentFileName_whenAttemptFileOpenStoreSuppressed_thenSuppressedExceptionAvailable() throws IOException {
        try {
            demoAddSuppressedException("/non-existent-path/non-existent-file.txt");
        } catch (Exception e) {
            assertThat(e, instanceOf(NullPointerException.class));
            assertEquals(1, e.getSuppressed().length);
            assertThat(e.getSuppressed()[0], instanceOf(FileNotFoundException.class));
        }
    }
}
