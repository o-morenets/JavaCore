package _20_multithreading._05_synchronized_method.synchronized_run;

public class SynchronizeRunMethodTest implements Runnable {

    /**
     * Synchronizing a run method brings single thread behavior.
     * In other words, In case you start multiple threads using the same runnable implementation in the constructor of the Thread then it would work.
     * But until the first thread finishes the second thread cannot start as all the threads depends on lock of a single object.
     *
     * If you synchronize the run method, there are two outcomes:
     * 1) Synchronize does not help, if the threads are created using different runnable instances.
     * 2) There is no multi-threading, if all threads are created using the same runnable.
     */
    public synchronized void run() {
        System.out.println(Thread.currentThread().getName() + " is starting");
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " is running");
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " is finished");
    }

    public static void main(String[] args) throws InterruptedException {
        sameRunnable(); // 1
        System.out.println("========================================================");
        differentRunnable(); // 2
    }

    private static void sameRunnable() throws InterruptedException {
        SynchronizeRunMethodTest test = new SynchronizeRunMethodTest();
        Thread t1 = new Thread(test);
        Thread t2 = new Thread(test);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

    private static void differentRunnable() {
        SynchronizeRunMethodTest test1 = new SynchronizeRunMethodTest();
        SynchronizeRunMethodTest test2 = new SynchronizeRunMethodTest();
        Thread t1 = new Thread(test1);
        Thread t2 = new Thread(test2);
        t1.start();
        t2.start();
    }
}