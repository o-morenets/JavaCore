package _13_interfaces._02_ActionListener;

import javax.swing.*;
import java.awt.event.ActionListener;

public class TimerTest {

	public static void main(String[] args) {
		ActionListener listener = new TimePrinter();
		Timer t = new Timer(10000, listener);
		t.start();
		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);
	}
}
