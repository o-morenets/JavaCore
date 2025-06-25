package producer_consumer_std_in;

import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * Run in terminal:
 * java Producer.java | java Consumer.java
 * ctrl + C to stop
 */
public class Producer {

    public static void main(String[] args) {
        Consumer<String> slowPrinter = input -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println(input);
        };

        Stream.generate(System::nanoTime)
                .map(String::valueOf)
                .forEach(slowPrinter);
    }
}
