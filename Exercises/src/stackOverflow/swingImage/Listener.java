package stackOverflow.swingImage;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class Listener implements MouseListener, MouseMotionListener
{
	private A a;
	private boolean b_isBeingDragged;
	private int DistanceToTheEndX;
	private int DistanceToTheEndY;
	private B CurrentB;

	public Listener(A a)
	{
		this.a = a;
		b_isBeingDragged = false;
		DistanceToTheEndX = DistanceToTheEndY = 0;
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		if (e.getButton() == MouseEvent.BUTTON1)
		{
			for (B s : a.Bs)
			{
				if (e.getX() >= s.x && e.getX() <= (s.x + s.width) &&
						e.getY() >= s.y && e.getY() <= (s.y + s.height))
				{
					CurrentB = s;
					DistanceToTheEndX = e.getX() - s.getX();
					DistanceToTheEndY = e.getY() - s.getY();
					b_isBeingDragged = true;
					System.out.println(CurrentB.x + " " + CurrentB.y + " " + e.getX() + " " + e.getY() + " " + "pressed");
				}
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		if (b_isBeingDragged)
		{
			b_isBeingDragged = false;
			CurrentB.x = e.getX();
			CurrentB.y = e.getY();
			a.repaint();
			System.out.println(CurrentB.x + " " + CurrentB.y + " " + e.getX() + " " + e.getY() + " " + "released");
		}
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
	}

	@Override
	public void mouseDragged(MouseEvent e)
	{
		if (b_isBeingDragged)
		{
			CurrentB.x = e.getX() - DistanceToTheEndX;
			CurrentB.y = e.getY() - DistanceToTheEndY;
			a.repaint();
			System.out.println(CurrentB.x + " " + CurrentB.y + " " + e.getX() + " " + e.getY() + " " + "dragged");
		}
	}

	@Override
	public void mouseMoved(MouseEvent e)
	{
		a.repaint();
	}
}