package stackOverflow.ticTacToeSockets;

import javax.swing.*;

public class MainGame {

    public MainGame() {
        InitUI();
    }


    private static void InitUI() {
        JFrame Field = new JFrame();
        Initial Grid = new Initial();
        Field.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Field.setSize(500, 500);
        Field.setLocationRelativeTo(null);
        Field.add(Grid);
        Field.setVisible(true);
    }
}