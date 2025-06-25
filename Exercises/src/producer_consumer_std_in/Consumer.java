package producer_consumer_std_in;

import java.util.Scanner;

/**
 * Run in terminal:
 * java Producer.java | java Consumer.java
 * ctrl + C to stop
 */
public class Consumer {

    public static void main(String[] args) {
        try(var s = new Scanner(System.in)) {
            for (; ; ) {
                var line = s.nextLine();
                System.out.println("-. " + line);
            }
        }
    }
}
