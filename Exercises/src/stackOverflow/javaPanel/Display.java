
package stackOverflow.javaPanel;

import java.awt.*;
import javax.swing.*;
public class Display extends Java_Panel{
    public static Java_Panel Java_Panel = new Java_Panel();
    public static Java_Frame Java_Frame = new Java_Frame(Java_Panel);

    public static void main(String[] args){
        Java_Panel.ACI_Start(Label_Container.F_Label);
    }
}

class Java_Frame extends JFrame{
    public Java_Frame(Java_Panel Java_Panel){
        super("DoW");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        add(Java_Panel);
        setVisible(true);
    }
}

class Java_Panel extends JPanel{
    public Java_Panel(){
        super();
        setBackground(Color.BLACK);
        add(Label_Container.F_Label);
    }

    public void ACI_Start(Java_Label Java_Label){
        for(int alpha_channel = 0; alpha_channel < 255; alpha_channel++){
            Java_Label.setForeground(new Color(255, 255, 255, alpha_channel));
            Java_Label.repaint();
            try {
                Thread.sleep(8);
            } catch (InterruptedException InterruptedExpection) {
                return;
            }
        }
    }
}

class Java_Label extends JLabel{
    public Java_Label(String java_string, Color Color,
                      String Font_Name, int Font_Size){
        super(java_string);
        setForeground(Color);
        setVerticalAlignment(JLabel.CENTER);
        setHorizontalAlignment(JLabel.CENTER);
        setFont(new Font(Font_Name, Font.PLAIN, Font_Size));
        setPreferredSize(new Dimension(300, 300));
    }
}

class Label_Container{
    static Java_Label F_Label = new Java_Label("Some_Text", new Color(255, 255, 255, 0),
            "Arial", 50);
}