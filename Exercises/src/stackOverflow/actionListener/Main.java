package stackOverflow.actionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		Menu menu = new Menu();
		Assembly assembly = new Assembly();
		Server server = new Server();
		JFrame Mainframe = new JFrame();
		JPanel Mainpanel = new JPanel();

		Mainframe.setSize(1050, 700);
		Mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Mainframe.add(Mainpanel);
		Mainframe.setTitle("none");
		JCheckBox licence = new JCheckBox("Лицензия");
		licence.setBounds(450, 630, 150, 30);
		Mainpanel.add(licence);
		licence.setSelected(false);

		JLabel version = new JLabel("Версия:");
		version.setBounds(20,560,150,20);
		Mainpanel.add(version);
		String[] items = {
				"1.12.2",
				"1.12.2 Forge",
				"1.12.2 Forge+Optifine"
		};
		JComboBox version_ComboBox = new JComboBox(items);
		version_ComboBox.setBounds(70,560,150,20);
		Mainpanel.add(version_ComboBox);

		JLabel licence_password = new JLabel("Пароль");
		JTextField password = new JTextField(20);
		licence_password.setBounds(200, 560, 100, 100);
		Mainpanel.add(licence_password);
		licence_password.setVisible(false);

		password.setBounds(180, 620, 150, 20);
		Mainpanel.add(password);
		password.setVisible(false);

		if (licence.isSelected()) {

			licence_password.setVisible(true);
			password.setVisible(true);

		}
		licence.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				licence_password.setVisible(licence.isSelected());
				password.setVisible(licence.isSelected());
			}
		});

		Mainframe.setVisible(true);
	}
}