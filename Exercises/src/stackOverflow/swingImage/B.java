package stackOverflow.swingImage;

import java.awt.*;
import javax.swing.*;

public class B extends JPanel {
	public int x;
	public int y;

	public final int width = 100;
	public final int height = 100;

	public B()
	{
		x=0;
		y=0;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.fillRect(x,y, width, height);
		repaint();
	}
}