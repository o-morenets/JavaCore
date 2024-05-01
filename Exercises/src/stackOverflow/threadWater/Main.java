package stackOverflow.threadWater;

public class Main {
    public static void main(String[] args) {
        Cup cup = new Cup();
        new DrinkWater(cup).start();
        new AddWater(cup).start();
    }
}