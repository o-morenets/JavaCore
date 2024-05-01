
package stackOverflow.javaLabel;

import java.awt.*;
import javax.swing.*;

public class Display {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Java_Panel Java_Panel = new Java_Panel();
            Java_Panel.setLabel(Label_Container.F_Label, "Center");
            new Java_Frame("Example", JFrame.EXIT_ON_CLOSE, Java_Panel);
        });
        Label_Container.F_Label.setAlphaAnimation(254, 8);
        Label_Container.F_Label.setAlphaAnimation(0, 8);
    }
}

class Java_Frame extends JFrame {
    public Java_Frame(String Frame_Name, int Close_Operation, Java_Panel Java_Panel) {
        super(Frame_Name);
        setDefaultCloseOperation(Close_Operation);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        add(Java_Panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

class Java_Panel extends JPanel {
    public Java_Panel() {
        super();
        setBackground(Color.BLACK);
        setLayout(new BorderLayout());
    }

    public void setLabel(Java_Label Java_Label, String Position) {
        add(Java_Label, Position);
    }
}

class Java_Label extends JLabel {
    Color Color_Data;

    public Java_Label(String Java_String, Color Color,
                      String Font_Name, int Font_Size, int Position) {
        super(Java_String, Position);
        setForeground(Color);
        setFont(new Font(Font_Name, Font.PLAIN, Font_Size));
        this.Color_Data = Color;
    }

    public void setAlphaAnimation(int n_alpha_channel,
                                  int sleep_time) {
        int Difference = Math.abs(this.Color_Data.getAlpha() - n_alpha_channel);
        int negative_check = (this.Color_Data.getAlpha() - n_alpha_channel) / Difference;
        int alpha_channel = this.Color_Data.getAlpha();
        for (int i = 0; i < Difference; i++) {
            alpha_channel -= negative_check;
            setForeground(this.Color_Data = new Color(this.Color_Data.getRed(), this.Color_Data.getGreen(),
                    this.Color_Data.getBlue(), alpha_channel));
            try {
                Thread.sleep(sleep_time);
            } catch (InterruptedException InterruptedException) {
                return;
            }
        }
    }
}

class Label_Container {
    static Java_Label F_Label = new Java_Label("Some_Company", new Color(255, 255, 255, 0),
            "Serif", 40, SwingConstants.CENTER);
}