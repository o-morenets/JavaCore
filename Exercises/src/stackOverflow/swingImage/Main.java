package stackOverflow.swingImage;

import javax.swing.*;

public class Main {
	public static void main(String[] args)
	{
		JFrame jf = new JFrame();
		jf.setSize(500, 500);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		A a = new A();
		jf.add(a);

		Listener l = new Listener(a);
		jf.addMouseMotionListener(l);
		jf.addMouseListener(l);

		jf.setVisible(true);
	}
}