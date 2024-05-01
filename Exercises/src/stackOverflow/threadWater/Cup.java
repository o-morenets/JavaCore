
package stackOverflow.threadWater;

public class Cup {
    int cap = 100;
    int time = 0;

    public synchronized int getCap() {
        return cap;
    }

    public synchronized int getTime() {
        return time;
    }

    public synchronized void add() {
        while (cap >= 100) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        cap += 10;
        System.out.println("+ (" + cap + ")");
        time += 6;
        notify();
    }

    public synchronized int drink() {
/*
        while (cap <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
*/

        cap -= 10;
        System.out.println("- (" + cap + ")");
        time += 3;
//        plus.interrupt();
        notify();

        return cap;
    }
}
