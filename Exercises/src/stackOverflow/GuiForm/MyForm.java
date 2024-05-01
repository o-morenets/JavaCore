package stackOverflow.GuiForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyForm {
    private JPanel panel1;
    private JButton buttonPlay;
    private JButton buttonStop;
    public boolean b = false;

    public class Run implements Runnable {
        Thread t;

        Run() {
            t = new Thread(this);
            t.start();
        }

        @Override
        public void run() {
            for (; ; ) {
                try {
                    Robot r = new Robot();
                    r.mouseMove(350, 657);
                    Thread.sleep(3000);   //сам цикл
                    r.mouseMove(568, 369);
                    Thread.sleep(3000);
                    if (b) break;
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public MyForm() {
        panel1 = new JPanel();

        panel1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {


            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
            }
        });

        buttonStop = new JButton("STOP");
        panel1.add(buttonStop);
        buttonStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(null, "Программа остановилась!");
                b = true; //стоп цикл
            }
        });

        buttonPlay = new JButton("Play");
        panel1.add(buttonPlay);
        buttonPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Run r = new Run(); //запуск цикла
//                r.run();
                JOptionPane.showMessageDialog(null, "Программа запустилась!");
            }
        });
    }

    public static void main(String args[]) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(new MyForm().panel1);
                frame.pack();
                frame.setSize(100, 100);
            }
        });

    }

}
