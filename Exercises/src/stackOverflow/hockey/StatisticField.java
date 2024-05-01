package stackOverflow.hockey;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatisticField extends JPanel {
    public final  static int STATISTIC_FIELD_H = 400;                                        // Высота статистического поля
    public final static int STATISTIC_FIELD_W = 200;                                        // Ширина статистического поля

    // Компоненты
    private static Label player1Name = new Label("Player 1", Label.CENTER);

    private static Label player2Name = new Label("Player 2", Label.CENTER);

    private TextField player1NameTextField = new TextField();
    private TextField player2NameTextField = new TextField();

    private static Label point1 = new Label("0", Label.CENTER);
    private static Label point2 = new Label("0", Label.CENTER);

    private static Button start = new Button("Start Game");

    public static Label getPoint1() {
        return point1;
    }

    public static Label getPoint2() {
        return point2;
    }

    public static Label getPlayer1Name() {
        return player1Name;
    }

    public static Label getPlayer2Name() {
        return player2Name;
    }

    public static Button getStart() {
        return start;
    }

    public StatisticField() {

        // Шрифт счета
        Font font = new Font("TimesRoman", Font.BOLD, 100);

        // Компоненты
        JPanel settingPanel = new JPanel();
        JPanel setting1player = new JPanel();
        JPanel setting2player = new JPanel();
        JPanel points = new JPanel();
        Label colon = new Label(":", Label.CENTER);
        Border border = BorderFactory.createCompoundBorder(
                BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder());
        Label setting1Up = new Label("\"W\" - UP", Label.CENTER);
        Label setting2Up = new Label("\"UP\" - UP", Label.CENTER);
        Label setting1Down = new Label("\"S\" - DOWN", Label.CENTER);
        Label setting2Down = new Label("\"DOWN\" - DOWN", Label.CENTER);
        Button renamePlayer1 = new Button("Rename");
        Button renamePlayer2 = new Button("Rename");

        // Установка менеджеров компановки
        setLayout(new GridLayout(3, 1));
        setting1player.setLayout(new GridLayout(5, 1));
        setting2player.setLayout(new GridLayout(5, 1));
        settingPanel.setLayout(new GridLayout(1, 2));
        points.setLayout(new GridLayout(1, 3));

        // Установка рамок
        settingPanel.setBorder(border);
        points.setBorder(border);

        // Установка шрифта
        point1.setFont(font);
        point2.setFont(font);
        colon.setFont(font);

        // Добавление на панель points
        points.add(point1);
        points.add(colon);
        points.add(point2);

        // Добавление на панель setting1player
        setting1player.add(player1Name);
        setting1player.add(setting1Up);
        setting1player.add(setting1Down);
        setting1player.add(player1NameTextField);
        setting1player.add(renamePlayer1);

        // Добавление на панель setting2player
        setting2player.add(player2Name);
        setting2player.add(setting2Up);
        setting2player.add(setting2Down);
        setting2player.add(player2NameTextField);
        setting2player.add(renamePlayer2);

        // Добавление на панель settingPanel
        settingPanel.add(setting1player);
        settingPanel.add(setting2player);

        // Добавление на статистическое поле
        add(points);
        add(settingPanel);
        add(start);

        // Обработчик кнопки start
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start.setLabel("Continue Game");
                GameField.setInGame(true);
                MainWindow.jFrame.requestFocus();
            }
        });

        // Обработчик кнопки renamePlayer1
        renamePlayer1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!player1NameTextField.getText().equals("")) {
                    player1Name.setText(player1NameTextField.getText());
                    player1NameTextField.setText("");
                }
            }
        });

        // Обработчик кнопки renamePlayer2
        renamePlayer2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!player2NameTextField.getText().equals("")) {
                    player2Name.setText(player2NameTextField.getText());
                    player2NameTextField.setText("");
                }
            }
        });
    }
}
