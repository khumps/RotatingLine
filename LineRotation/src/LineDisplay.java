import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.*;


public class LineDisplay extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6883927989034504376L;
	
	
	Rectangle lineCanvas;
	int width = 60;
	int height = 60;
	Point start = new Point(0,0);
	Point end = new Point(5,5);
	private Line l = new Line(start,end);
	int orientation;
	
	public void paintComponent(Graphics gr){
		super.paintComponent(gr);
		gr.setColor(Display.getC());
		gr.drawLine(l.getEndPoints()[0].x,l.getEndPoints()[0].y,l.getEndPoints()[1].x,l.getEndPoints()[1].y);
		//gr.drawLine(l.getEndPoints()[0].x,l.getEndPoints()[0].y, getWidth(), getHeight());
		orientation = l.getOrientation();
	}

	public Line getL() {
		return l;
	}

	public void setL(Line l) {
		this.l = l;
	}
	
	
	
}
