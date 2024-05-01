package stackOverflow.trickySwitch;

import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

    public static void main(String[] args) {
        try (FileReader reader = new FileReader("notes12.txt"))
        {
            // читаем посимвольно
            int c;

            while ((c = reader.read()) != -1) {

                switch(c) {
                    case 13: case 10:
                        c =32;
                    case 32:

                        System.out.println("New line");

//                        massive[counter] = "";
//                        counter++;
                        break;

                    case 9:  case 44: case 40: case 41:case 33:case 34: case 46: case 48: case 49: case 50: case 51: case 52: case 53: case 54: case 55: case 56: case 57:
                        break;

                    default:
                        System.out.print((char) c);
//                        massive[counter] = massive[counter] + (char) c;
                }
            }
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }
}
