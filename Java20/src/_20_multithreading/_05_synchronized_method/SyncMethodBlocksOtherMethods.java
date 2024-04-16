package _20_multithreading._05_synchronized_method;

import java.util.concurrent.TimeUnit;

public class SyncMethodBlocksOtherMethods {

    public static void main(String[] args) {
        Task task = new Task();

        new Thread(task::addition).start();
        new Thread(task::division).start();
    }
}

class Task {

    private final Object syncForAdd = new Object();
    private final Object syncForDiv = syncForAdd;

    synchronized void addition() {
//        synchronized (syncForAdd) {
            for (int i = 0; i < 3; i++) {
                System.out.println("Addition...");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
//        }
    }

    synchronized void division() {
//        synchronized (syncForDiv) {
            for (int i = 0; i < 3; i++) {
                System.out.println("    Division...");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
//        }
    }
}