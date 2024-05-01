package stackOverflow.dataReadFromFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;

public class Main {
    static String[] name = new String[100];
    static int[] score = new int[100];

    public static void main(String[] args) throws IOException {
        new Main().readFile();
        System.out.println(Arrays.toString(name));
        System.out.println(Arrays.toString(score));
    }

    void readFile() throws IOException
    {
        File file = null;
        try {
            file = new File(getClass().getClassLoader().getResource("text.txt").toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        try (FileReader fr = new FileReader(file);
             BufferedReader reader = new BufferedReader(fr))
        {
            String temp;
            int index = 0;
            while ((temp = reader.readLine()) != null)
            {
                String[] parts = temp.split(";");
                Main.name[index] = parts[0];
                Main.score[index] = Integer.parseInt(parts[1]);
                index++;
            }
        }
    }
}
