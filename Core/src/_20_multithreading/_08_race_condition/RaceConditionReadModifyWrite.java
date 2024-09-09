package _20_multithreading._08_race_condition;


class Counter {

    private int count;

    public int getCount() {
        return count;
    }

    // synchronized prevents race condition of type read-modify-write
    public synchronized int incrementAndGet() {
        count++;
        return count;
    }
}

public class RaceConditionReadModifyWrite {

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
    }
}
