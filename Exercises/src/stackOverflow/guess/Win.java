
package stackOverflow.guess;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.net.URL;

public class Win extends GUI {
    JFrame frame = new JFrame("Победа!");
    JPanel panel = new JPanel();
    JLabel text = new JLabel("Вы угадали число!");
    JLabel text2 = new JLabel("Кол-во попыток: " + this.counter);

    Win() {
        URL iconURL = getClass().getResource("question.png");
//        ImageIcon icon = new ImageIcon(iconURL);
//        this.frame.setIconImage(icon.getImage());

        this.panel.add(this.text);
        this.panel.add(this.text2);
        this.frame.add(this.panel);


        this.frame.setResizable(false);
        this.frame.setSize(250, 200);
        this.frame.setLocationRelativeTo(null);
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
    }
}