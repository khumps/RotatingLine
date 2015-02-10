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
	int width = 600;
	int height = 600;
	Point start = new Point(0,0);
	Point end = new Point(width,height);
	private Line l = new Line(start,end);
	
	public void paintComponent(Graphics gr){
		super.paintComponent(gr);
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
//test
}
