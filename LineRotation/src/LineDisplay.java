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
	int width = 60;
	int height = 60;
	Point start = new Point(0,0);
	Point end;
	private Line l;
	boolean isResized = true;
	
	public void paintComponent(Graphics gr){
		super.paintComponent(gr);
		if(isResized)
		{
			isResized = false;
			width = getWidth();
			height = getHeight();
			end = new Point(width,height);
			l = new Line(start,end);
			
		}
		gr.setColor(c);
		gr.drawLine(l.getEndPoints()[0].x,l.getEndPoints()[0].y,l.getEndPoints()[1].x,l.getEndPoints()[1].y);
		//gr.drawLine(l.getEndPoints()[0].x,l.getEndPoints()[0].y, getWidth(), getHeight());
	}

	public Line getL() {
		return l;
	}

	public void setL(Line l) {
		this.l = l;
	}
	
	public void isResized()
	{
		isResized = false;
	}
}
