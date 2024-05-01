package stackOverflow.hockey;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static java.awt.event.KeyEvent.*;


public class MainWindow {
    static JFrame jFrame;

    public MainWindow(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // Инициализация фрейма
        jFrame = new JFrame();
        jFrame.setLocation(screenSize.width/2 - (StatisticField.STATISTIC_FIELD_W + GameField.GAME_FIELD_W)/2,
                screenSize.height/2 - StatisticField.STATISTIC_FIELD_H/2);
        jFrame.setTitle("Air Hockey");
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.setLayout(new FlowLayout());
        jFrame.setResizable(false);
        Thread player2Move = new Thread(new Runnable() {
            @Override
            public void run() {
                jFrame.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        super.keyPressed(e);
                        if (e.getKeyCode() == VK_UP) {
                            GameField.setPlayer2Y(GameField.getPlayer2Y() - 5);
                            jFrame.repaint(5);
                        }

                        if (e.getKeyCode() == VK_DOWN) {
                            GameField.setPlayer2Y(GameField.getPlayer2Y() + 5);
                            jFrame.repaint(5);
                        }
                    }
                });
            }
        });

        Thread player1Move = new Thread(new Runnable() {
            @Override
            public void run() {
                jFrame.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        super.keyPressed(e);
                        if (e.getKeyCode() == VK_W){
                            GameField.setPlayer1Y(GameField.getPlayer1Y() - 5);
                            jFrame.repaint(5);
                        }

                        if (e.getKeyCode() == VK_S) {
                            GameField.setPlayer1Y(GameField.getPlayer1Y() + 5);
                            jFrame.repaint(5);
                        }
                    }
                });
            }
        });

        player1Move.start();
        player2Move.start();

        // Создание игрового и статистического поля
        StatisticField statisticField = new StatisticField();
        GameField gameField = new GameField();
        statisticField.setPreferredSize(new Dimension(StatisticField.STATISTIC_FIELD_W, StatisticField.STATISTIC_FIELD_H));
        gameField.setPreferredSize(new Dimension(GameField.GAME_FIELD_W, GameField.GAME_FIELD_H));

        jFrame.add(gameField);
        jFrame.add(statisticField);
        jFrame.pack();

    }


    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow();
    }
}
