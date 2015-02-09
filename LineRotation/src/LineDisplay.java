import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;


public class LineDisplay extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6883927989034504376L;
	public Line l;
	private Color c = new Color(0,0,0);
	
	public void paintComponent(Graphics gr){
		super.paintComponent(gr);
		Point start = new Point(0,0);
		Point end = new Point(getWidth(), getHeight());
		l = new Line(start,end);
		gr.setColor(c);
		gr.drawLine(l.endPoints[0].x,l.endPoints[0].y,l.endPoints[1].x,l.endPoints[1].y);
	}
}
