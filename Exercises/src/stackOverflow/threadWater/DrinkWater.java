
package stackOverflow.threadWater;

public class DrinkWater extends Thread {
    private Cup cup;

    public DrinkWater(Cup cup) {
        this.cup = cup;
    }

    @Override
    public void run() {
        while (!interrupted()) {
            int cap = cup.drink();
            if (cap <= 0) {
                break;
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException ignored) {
            }
        }
    }
}
