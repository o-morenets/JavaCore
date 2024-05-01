
package stackOverflow.threads;

public class Solution {
    public static volatile Integer a = 0;

    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    for (int i = 0; i < 5000; i++) {
                        Solution.a++;
                    }
                }
            }
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        Thread thread4 = new Thread(runnable);
        Thread thread5 = new Thread(runnable);
/*
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        MyThread thread3 = new MyThread();
        MyThread thread4 = new MyThread();
        MyThread thread5 = new MyThread();
*/
        // Start
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        //Join
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        thread5.join();
        System.out.println(a);
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        synchronized (Integer.class) {
            for (int i = 0; i < 5000; i++) {
                Solution.a++;
            }
        }
    }
}
