package stackOverflow.swingLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

public class Main {

    public static void setEast(JFrame fr) {
        JPanel myPanel2 = new JPanel();
        ArrayList<JButton> masB = new ArrayList<>();
        myPanel2.setLayout(new GridLayout(6,3));

        for(int i = 0; i < 8; i++) {
            masB.add(new JButton("Кнопка" + i));
            myPanel2.add(masB.get(i));
            myPanel2.add(new JTextArea());
        }

        fr.add(myPanel2, BorderLayout.EAST);
    }

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setSize(800, 600);
        setEast(jFrame);
        jFrame.setVisible(true);
    }
}
