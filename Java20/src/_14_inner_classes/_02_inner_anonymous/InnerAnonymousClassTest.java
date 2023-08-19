package _14_inner_classes._02_inner_anonymous;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class InnerAnonymousClassTest {

	public static void main(String[] args) {
		TalkingClock clock = new TalkingClock(1000, true);
		clock.start();
		// run program until user presses OK button
		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);
	}

}

class TalkingClock {
	private int interval;
	private boolean beep;

	public TalkingClock(int interval, boolean beep) {
		this.interval = interval;
		this.beep = beep;
	}

	public void start() {
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("At the tone, the time is " + new Date());
				if (beep)
					Toolkit.getDefaultToolkit().beep();
			}
		};
		
		Timer t = new Timer(interval, listener);
		t.start();
	}

}
