package stackOverflow.XO;

public class Main {

    public static void main(String[] args) {
        Logic logic = new Logic();
        logic.pickPlayer();
        logic.initMap();
        if (logic.pick2 == 2) {
            if (logic.pick1 == 1) {
                while (true) {
                    logic.human();
                    logic.printMap();
                    if (logic.checkWin(logic.DOT_X)) {
                        System.out.println("Победил человек!");
                        break;
                    }
                    if (logic.isMapFull()) {
                        System.out.println("Ничья");
                        break;
                    }
                    logic.AI();
                    logic.printMap();
                    if (logic.checkWin(logic.DOT_O)) {
                        System.out.println("Победил AI!");
                        break;
                    }
                    if (logic.isMapFull()) {
                        System.out.println("Ничья");
                        break;
                    }
                }
            } else {
                while (true) {
                    logic.AI();
                    logic.printMap();
                    if (logic.checkWin(logic.DOT_X)) {
                        System.out.println("Победил AI!");
                        break;
                    }
                    if (logic.isMapFull()) {
                        System.out.println("Ничья");
                        break;
                    }
                    logic.human();
                    logic.printMap();
                    if (logic.checkWin(logic.DOT_O)) {
                        System.out.println("Победил человек!");
                        break;
                    }
                    if (logic.isMapFull()) {
                        System.out.println("Ничья");
                        break;
                    }
                }
            }
        } else {
            while (true) {
                logic.human();
                logic.printMap();
                if (logic.checkWin(logic.DOT_X)) {
                    System.out.println("Победил первый игрок!");
                    break;
                }
                if (logic.isMapFull()) {
                    System.out.println("Ничья");
                    break;
                }
                logic.humanTwo();
                logic.printMap();
                if (logic.checkWin(logic.DOT_O)) {
                    System.out.println("Победил второй игрок!");
                    break;
                }
                if (logic.isMapFull()) {
                    System.out.println("Ничья");
                    break;
                }
            }
        }
    }
}