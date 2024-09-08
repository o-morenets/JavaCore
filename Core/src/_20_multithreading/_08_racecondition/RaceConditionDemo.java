package _20_multithreading._08_racecondition;

public class RaceConditionDemo {

    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();

        Runnable runnable = () -> {
            for (int i = 0; i < 1_000_000; i++) {
                counter.incrementAndGet();
            }
            System.out.println(Thread.currentThread().getName() + " count = " + counter.getCount());
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("counter = " + counter.getCount());
    }
}

class Counter {
    private int count = 0;

    public int getCount() {
        return count;
    }

    public int incrementAndGet() {
        count++;
        return count;
    }
}