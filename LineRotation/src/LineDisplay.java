import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;

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
	int strokeWidth = 2;
	Stroke stroke = new BasicStroke(strokeWidth);
	
	public void paintComponent(Graphics gr){
		Graphics2D gr2 = (Graphics2D)gr;
		super.paintComponent(gr);
		gr2.setStroke(new BasicStroke(strokeWidth));
		gr.setColor(Display.getC());
		gr.drawLine(l.getEndPoints()[0].x,l.getEndPoints()[0].y,l.getEndPoints()[1].x,l.getEndPoints()[1].y);
		orientation = l.getOrientation();
	}

	public Line getL() {
		return l;
	}

	public void setL(Line l) {
		this.l = l;
	}
	
	public void setStroke()
	{
		
	}
	
	
	
}
