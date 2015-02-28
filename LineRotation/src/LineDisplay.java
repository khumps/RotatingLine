import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

import javax.swing.*;

/**
 * 
 * @author Vijay Jeevanandam
 * @author Kevin Humphreys
 * <br><br>
 * Creates a line by utilizing Graphics
 *
 */
public class LineDisplay extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6883927989034504376L;
	
	
	/**
	 * Rectangle lineCanvas;
	 */
	int width = 60;
	int height = 60;
	/**
	 * Data for the LineDisplay class.
	 * Start point and end point for the line
	 * Creates a new line
	 * int orientation for the line
	 * new Stroke for the ine
	 */
	Point start = new Point(0,0);
	Point end = new Point(5,5);
	private Line l = new Line(start,end);
	int orientation;
	Stroke stroke = new BasicStroke(10);
	
	/**
	 * paintComponent method:
	 * Creates a line with Graphics.
	 * The line is made with temporary start and end points
	 * The orientation of the line is made
	 */
	public void paintComponent(Graphics gr){
		Graphics2D gr2 = (Graphics2D)gr;
		super.paintComponent(gr);
		gr2.setStroke(stroke);
		gr.setColor(Display.getC());
		gr.drawLine(l.getTempEndPoints()[0].x,l.getTempEndPoints()[0].y,l.getTempEndPoints()[1].x,l.getTempEndPoints()[1].y);
		orientation = l.getOrientation();
	}
	
	/**
	 * A getter for the Line
	 * @return Line "l"
	 */
	public Line getL() {
		return l;
	}
	
	/**
	 * A setter for the line
	 * @param Line "l"
	 */
	public void setL(Line l) {
		this.l = l;
	}
	
	
}
