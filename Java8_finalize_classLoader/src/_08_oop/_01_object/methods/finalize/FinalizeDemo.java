package _08_oop._01_object.methods.finalize;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FinalizeDemo {

    private final BufferedReader reader;

    public FinalizeDemo() {
        InputStream input = this.getClass()
                .getClassLoader()
                .getResourceAsStream("file.txt");
        this.reader = new BufferedReader(new InputStreamReader(input));
    }

    public static void main(String[] args) throws Exception {
        new FinalizeDemo().readFirstLine();
        System.gc();
    }

    public String readFirstLine() throws IOException {
        return reader.readLine();
    }

    // other class members

    @Override
    protected void finalize() {
        try {
            reader.close();
            System.out.println("Closed BufferedReader in the finalizer");
        } catch (IOException e) {
            // ...
        }
    }
}
