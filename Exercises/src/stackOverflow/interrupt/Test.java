package stackOverflow.interrupt;

public class Test {

    public static void main(String[] args) {
        System.out.println("Start T1");
        Thread t = new T1();
        t.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ie) {
        }
        t.interrupt();
        System.out.println("Of T1");
    }

    public static class T1 extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException ie) {
                interrupt();
                System.out.println(isInterrupted());
                System.out.println("T1");
            }
        }
    }
}
