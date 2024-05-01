package stackOverflow.swingImage;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class A extends JPanel{
	public ArrayList<B> Bs;
	public A()
	{
		Bs = new ArrayList<>();
		Bs.add(new B());
	}


	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for (B b: Bs)
			b.paint(g);
	}
}