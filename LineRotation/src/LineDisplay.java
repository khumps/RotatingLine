import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.*;


public class LineDisplay extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6883927989034504376L;
	private Color c = new Color(0,0,0);
	Rectangle lineCanvas;
	int width = 500;
	int height = 500;
	int i = 0;
	Point start = new Point(0,0);
	Point end;
	private Line l;
	
	public void paintComponent(Graphics gr){
		super.paintComponent(gr);
		if(i == 0)
		{
		width = getWidth();
		height = getHeight();
		end = new Point(width,height);
		l = new Line(start,end);
		i++;
		}
		gr.setColor(c);
		//gr.drawLine(l.getEndPoints()[0].x,l.getEndPoints()[0].y,l.getEndPoints()[1].x,l.getEndPoints()[1].y);
		gr.drawLine(l.getEndPoints()[0].x,l.getEndPoints()[0].y, l.getEndPoints()[1].x, l.getEndPoints()[1].y);
	}
	
	public void isResized()
	{
		i = 0;
	}

	public Line getL() {
		return l;
	}

	public void setL(Line l) {
		this.l = l;
	}

}
