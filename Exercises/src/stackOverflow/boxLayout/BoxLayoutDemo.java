package stackOverflow.boxLayout;

import java.awt.*;
import javax.swing.*;

public class BoxLayoutDemo {

    public static void addComponentsToPane(Container pane) {
        JPanel settingField = new JPanel();
        settingField.setLayout(new BorderLayout());
        JPanel mainData = new JPanel();
        JPanel panelOne = new JPanel();
        JPanel panelTwo = new JPanel();

        mainData.setLayout(new BoxLayout(mainData, BoxLayout.Y_AXIS));
        mainData.setBackground(Color.cyan);
        panelOne.setPreferredSize(new Dimension(40,40));
        panelTwo.setPreferredSize(new Dimension(40,40));
        panelOne.setBackground(Color.white);
        panelTwo.setBackground(Color.yellow);
        mainData.add(panelOne);
        mainData.add(panelTwo);
        settingField.add(mainData);

        pane.add(settingField);
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("BoxLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set up the content pane.
        addComponentsToPane(frame.getContentPane());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(BoxLayoutDemo::createAndShowGUI);
    }
}