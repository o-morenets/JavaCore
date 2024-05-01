package stackOverflow.swingClientServer.Drawings;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;

import javax.swing.*;


public class DrawingOne extends JFrame {


    public static final int DEFAULT_WIDTH = 700;
    public static final int DEFAULT_HEIGHT = 500;

    public Color sunColor;
    public Color skyColor;

    public DrawComponent c;

    public static void main(String[] args) {
        new DrawingOne();
    }

    public DrawingOne() {
        setDaySky();

        Container container = getContentPane();
        container.setBackground(new Color(224, 196, 214));
        container.setLayout(new BorderLayout(20, 20));
        container.setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));

        ButtonListener listener = new ButtonListener();

        JButton j1 = new JButton("День");
        j1.addActionListener(listener);
        JButton j2 = new JButton("Ночь");
        j2.addActionListener(listener);
        container.add(j1, BorderLayout.SOUTH);
        container.add(j2, BorderLayout.NORTH);

        c = new DrawComponent();
        container.add(c, BorderLayout.CENTER);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
//        setVisible(true);
    }

    public void setNightSky() {
        this.sunColor = new Color(202, 202, 202);
        this.skyColor = new Color(7, 78, 107);
    }

    public void setDaySky() {
        this.sunColor = Color.getHSBColor(197.4F, 42.6F, 92.2F);
        this.skyColor = new Color(135, 206, 235);
    }

    public class DrawComponent extends JComponent {

        @Override
        public void paint(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            // основа окна
            Rectangle2D.Double rectangle2Drect2 =
                    new Rectangle2D.Double(37, 26, 458, 280);
            g2.setStroke(new BasicStroke(3));
            g2.setColor(Color.black);
            g2.draw(rectangle2Drect2);
            g2.setColor(Color.white);
            g2.fill(rectangle2Drect2);

            //левое окно
            rectangle2Drect2 =
                    new Rectangle2D.Double(51, 40, 160, 250);
            g2.setStroke(new BasicStroke(3));
            g2.setColor(Color.black);
            g2.draw(rectangle2Drect2);
            g2.setColor(skyColor);
            g2.fill(rectangle2Drect2);

            // правое окно
            rectangle2Drect2 =
                    new Rectangle2D.Double(230, 40, 250, 250);
            g2.setStroke(new BasicStroke(3));
            g2.setColor(Color.black);
            g2.draw(rectangle2Drect2);
            g2.setColor(skyColor);
            g2.fill(rectangle2Drect2);

            // основа ручки
            rectangle2Drect2 =
                    new Rectangle2D.Double(215, 140, 10, 10);
            g2.setStroke(new BasicStroke(2));
            g2.setColor(Color.black);
            g2.draw(rectangle2Drect2);
            g2.setColor(Color.white);
            g2.fill(rectangle2Drect2);

            // ручка
            rectangle2Drect2 =
                    new Rectangle2D.Double(217, 142, 4, 30);
            g2.setStroke(new BasicStroke(2));
            g2.setColor(Color.black);
            g2.draw(rectangle2Drect2);
            g2.setColor(Color.white);
            g2.fill(rectangle2Drect2);

            // солнце
            g2.setColor(sunColor);
            g2.fillOval(100, 60, 80, 80);

            // горшок
            int[] xpoints = {230 + 60, 300 + 60, 285 + 61, 244 + 60};
            int[] ypoints = {240, 240, 290, 290};
            int npoints = 4;
            g2.setColor(new Color(172, 86, 30));
            g2.fillPolygon(xpoints, ypoints, npoints);

            // ствол цветка
            g2.setStroke(new BasicStroke(5));
            g2.setColor(new Color(0, 128, 0));
            g2.drawLine(325, 200, 325, 238);

            // лепестки
            g2.setColor(new Color(255, 192, 203));

            g2.fillOval(317, 200, 22, 22);
            g2.fillOval(317, 175, 22, 22);
            g2.fillOval(317 - 15, 190, 22, 22);
            g2.fillOval(317 + 13, 190, 22, 22);

            // центр цветка
            g2.setColor(new Color(255, 165, 0));
            g2.fillOval(317, 190, 15, 15);
        }

    }

    public class ButtonListener implements ActionListener, Serializable {

        @Override
        public void actionPerformed(ActionEvent event) {
            JButton button = (JButton) event.getSource();
            if (button.getText().equals("Ночь")) {
                setNightSky();
            } else {
                setDaySky();
            }
            c.repaint();
        }

    }
}