
package stackOverflow.threadInterrupt;

public class Main {

    public static void main(String[] args) {
        Horse horsik = new Horse();
        horsik.horseStop();
    }

    public static class Horse implements Runnable {
        Thread t;

        public Horse() {
            this.t = new Thread("Anna");
            this.t.start();
        }

        public void horseStop() {
            String trName = this.t.getName();
            System.out.println(trName);
            this.t.interrupt();
        }

        @Override
        public void run() {
            while (!Thread.interrupted()) {
            }
        }
    }
}
