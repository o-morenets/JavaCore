package stackOverflow.ticTacToeSockets;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

class Initial extends JComponent {

    protected static final int EMPTY_FIELD = 0;
    protected static final int X_FIELD = 10;
    protected static final int ZERO_FIELD = 100;
    public static int j;
    static int i;
    int[][] Field;
    boolean X_Turn;


    public Initial() {
        enableEvents(AWTEvent.MOUSE_EVENT_MASK);
        Field = new int[3][3];
        InitGame();
    }

    public void InitGame() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Field[i][j] = EMPTY_FIELD;
            }
        }
        X_Turn = true;
    }

    @Override
    protected void processMouseEvent(MouseEvent e) {

        if (e.getButton() == e.BUTTON1) {

            int x = e.getX();
            int y = e.getY();
            int i = (int) ((float) x / getWidth() * 3);
            int j = (int) ((float) y / getHeight() * 3);
            if (Field[i][j] == EMPTY_FIELD) {
                Field[i][j] = X_Turn ? X_FIELD : ZERO_FIELD;
                X_Turn = !X_Turn;
                repaint();
            }
            int result = ChekWin();
            if (result != 0) {
                if (result == X_FIELD * 3)
                    JOptionPane.showMessageDialog(this, "Победа крестиков!", "Победа", JOptionPane.INFORMATION_MESSAGE);
                else if (result == ZERO_FIELD * 3)
                    JOptionPane.showMessageDialog(this, "Победа ноликов!", "Победа", JOptionPane.INFORMATION_MESSAGE);
                else
                    JOptionPane.showMessageDialog(this, "Ничья!", "Ниья", JOptionPane.INFORMATION_MESSAGE);
                InitGame();
                repaint();
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        DrawGrid(g);
        ChekVoid(g);
    }

    protected void DrawGrid(Graphics graphics) {
        int w = getWidth();
        int h = getHeight();
        int dw = w / 3;
        int dh = h / 3;
        graphics.setColor(Color.BLACK);
        for (int i = 1; i < 3; i++) {
            graphics.drawLine(0, dh * i, w, dh * i);
            graphics.drawLine(dw * i, 0, dw * i, h);
        }
    }

    protected void DrawX(int i, int j, Graphics graphics) {
        graphics.setColor(Color.BLACK);
        int dw = getWidth() / 3;
        int dh = getHeight() / 3;
        int x = i * dw;
        int y = j * dh;
        graphics.drawLine(x, y, x + dw, y + dh);
        graphics.drawLine(x, y + dh, x + dw, y);
    }

    public void DrawZero(int i, int j, Graphics graphics) {
        graphics.setColor(Color.BLACK);
        int dw = getWidth() / 3;
        int dh = getHeight() / 3;
        int x = i * dw;
        int y = j * dh;
        graphics.drawOval(x + 5 * dw / 100, y, dw * 9 / 10, dh);
    }

    protected void ChekVoid(Graphics graphics) {
        for (int i = 0; i < 3; ++i)
            for (int j = 0; j < 3; ++j) {
                if (Field[i][j] == X_FIELD)
                    DrawX(i, j, graphics);
                else if (Field[i][j] == ZERO_FIELD)
                    DrawZero(i, j, graphics);
            }
    }

    protected int ChekWin() {
        int dg1 = 0, dg2 = 0;
        for (int i = 0; i < 3; i++) {
            dg1 += Field[i][i];
            dg2 += Field[i][2 - i];
        }
        if (dg1 == ZERO_FIELD * 3 || dg1 == X_FIELD * 3)
            return dg1;
        if (dg2 == ZERO_FIELD * 3 || dg2 == X_FIELD * 3)
            return dg2;
        boolean isEmpty = false;
        int chekH = 0, chekV = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Field[i][j] == 0) isEmpty = true;
                chekH += Field[i][j];
                chekV += Field[j][i];
            }
            if (chekH == ZERO_FIELD * 3 || chekH == X_FIELD * 3) break;
            if (chekV == ZERO_FIELD * 3 || chekV == X_FIELD * 3) break;
            chekV = 0;
            chekH = 0;
        }
        if (chekH == ZERO_FIELD * 3 || chekH == X_FIELD * 3)
            return chekH;
        if (chekV == ZERO_FIELD * 3 || chekV == X_FIELD * 3)
            return chekV;
        if (isEmpty)
            return 0;
        else
            return -1;
    }
}