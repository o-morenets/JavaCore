package stackOverflow.interrupt;

public class Clock extends Thread {
    private int seconds;

    @Override
    public void run() {
        try {
            while (!currentThread().isInterrupted()) {
                Thread.sleep(1000);
                seconds++;
                System.out.println(seconds);
            }
        } catch (InterruptedException e) {
            interrupt();
            System.out.println("Конец отсчета.");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Clock clock = new Clock();
        clock.start();
        Thread.sleep(5000);
        clock.interrupt();
    }
}