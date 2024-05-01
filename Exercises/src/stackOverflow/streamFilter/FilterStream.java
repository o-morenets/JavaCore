package stackOverflow.streamFilter;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class FilterStream {

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Path path = new File((i + 1) + ".txt").toPath();
            try {
                Stream<String> stringStream = Files.lines(path, StandardCharsets.UTF_8);
                if (stringStream.anyMatch(s -> s.contains("12"))) {
                    System.out.println(path);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
