package _08_oop._04_object.methods.finalize;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CloseableResource implements AutoCloseable {
    private BufferedReader reader;

    public CloseableResource() {
        InputStream input = this.getClass()
                .getClassLoader()
                .getResourceAsStream("_08_oop/_04_object/finalize/file.txt");
        reader = new BufferedReader(new InputStreamReader(input));
    }

    public String readFirstLine() throws IOException {
        String firstLine = reader.readLine();
        return firstLine;
    }

    @Override
    public void close() {
        try {
            reader.close();
            System.out.println("Closed BufferedReader in the close method");
        } catch (IOException e) {
            // handle exception
        }
    }

    public static void main(String[] args) throws IOException {
        try (CloseableResource resource = new CloseableResource()) {
            String firstLine = resource.readFirstLine();
        }
    }
}
