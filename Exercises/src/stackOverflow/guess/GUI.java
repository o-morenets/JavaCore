
package stackOverflow.guess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class GUI extends Random0100 {

    JFrame frame = new JFrame("6 sapkis");
    JPanel panel = new JPanel();
    JLabel label = new JLabel("Угадайте число от 0 до 100:");
    JLabel answer = new JLabel("");
    JButton button = new JButton("Отправить");
    JTextField pole = new JTextField("", 5);

    GUI() {

        URL iconURL = getClass().getResource("question.png");
//        ImageIcon icon = new ImageIcon(iconURL);
//        this.frame.setIconImage(icon.getImage());
        this.panel.add(this.label);
        this.panel.add(this.pole);
        this.panel.add(this.button);
        this.panel.add(this.answer);
        this.frame.add(this.panel);
        this.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int need = Integer.parseInt(GUI.this.pole.getText());
                GUI.this.counter++;
                if (need == GUI.this.guess) {
                    GUI.this.frame.setVisible(false);
                    Win open = new Win();

                } else {
                    GUI.this.answer.setText("Пробуйте еще");
                }
            }
        });
        this.answer.setForeground(Color.red);
        this.frame.setResizable(false);
        this.frame.setSize(230, 150);
        this.frame.setLocationRelativeTo(null);
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
    }
}

class Random0100 {
    int guess = (int) (Math.random() * 100);
    static int counter;

    Random0100() {
        System.out.println("Подсказка: " + this.guess);
    }
}