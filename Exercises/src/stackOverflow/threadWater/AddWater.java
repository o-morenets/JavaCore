
package stackOverflow.threadWater;

public class AddWater extends Thread {
    private Cup cup;

    public AddWater(Cup cup) {
        this.cup = cup;
    }

    @Override
    public void run() {
        while (!interrupted()) {
            if (cup.getCap() <= 0) {
                break;
            }
            cup.add();

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println("catch InterruptedException");
                break;
            }
        }
        System.out.println("time = " + cup.getTime());
    }
}
