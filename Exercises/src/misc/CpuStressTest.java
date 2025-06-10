package misc;

public class CpuStressTest {

    public static void main(String[] args) {
        int numberOfThreads = Runtime.getRuntime().availableProcessors() + 5000; // максимально доступні ядра

        System.out.println("Starting " + numberOfThreads + " threads to stress CPU...");

        for (int i = 0; i < numberOfThreads; i++) {
            Thread thread = new Thread(() -> {
                while (true) {
                    // нескінченне обчислення
                    Math.pow(Math.random(), Math.random());
                }
            });

            thread.setDaemon(true); // програма завершиться, якщо зупиниться main
            thread.start();
        }

        // щоб програма не завершилася миттєво
        try {
            Thread.sleep(1000 * 60 * 10); // 10 хвилин
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
