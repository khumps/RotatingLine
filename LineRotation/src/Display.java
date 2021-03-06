import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JSlider;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * 
 * @author Vijay Jeevanandam
 * @author Kevin Humphreys
 * <br>
 * <br>
 * A Display class that creates a JFrame of a rotating line with several functionalities
 *
 */
public class Display extends JFrame implements ActionListener,
		ComponentListener, ChangeListener {

	/**
	 * Data for the Display class.
	 * Color c is the color of the line that is drawn.
	 * Two timers created: 
	 * Timer t is utilized to rotate the line clockwise
	 * Timer ti is utilized to rotate the line counter-clockwise
	 * LineDisplay Line is the line that was created in the LineDisplay class
	 * int speed is the rotation speed of the line
	 * int rotateSpeed is the initial rotation speed of the line
	 * JSlider speedSlider: the slider that is used to change the speed of the line
	 * JSlider widthSlider: the slider that is used to change the width of the line
	 * 
	 */

	private static Color c = new Color(0,0,0);
	private static final long serialVersionUID = 454055181523406363L;
	public Timer t;	//clockwise timer
	public Timer ti; // counter-clockwise timer
	LineDisplay line = new LineDisplay();
	int speed = 10;
	int rotateSpeed = speed / 2;
	JSlider speedSlider;
	JSlider widthSlider;
	
	/**
	 * The Display constructor:
	 * Creates a new JFrame <br>										
	 * 			- Has a minimum size and a preferred size <br>
	 * 			- Has several buttons <br>
	 * 			- Uses 2 sliders	
	 */
	Display() {

		
		setDefaultLookAndFeelDecorated(true);
		setVisible(true);
		setMinimumSize(new Dimension(500, 500));
		setPreferredSize(new Dimension(600, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		line.addComponentListener(this);



		JMenuBar m = new JMenuBar();
		JMenuBar mBottom = new JMenuBar();
		JButton rotate = new JButton("Rotate Clockwise");
		rotate.addActionListener(this);
		rotate.setActionCommand("rotate");
		m.add(rotate);

		JButton rotatecc = new JButton("Rotate Counter - Clockwise");
		rotatecc.addActionListener(this);
		rotatecc.setActionCommand("cc");
		m.add(rotatecc);

		JButton stop = new JButton("Stop");
		stop.addActionListener(this);
		stop.setActionCommand("stop");
		m.add(stop);

		JButton color = new JButton("Change Color");
		color.addActionListener(this);
		color.setActionCommand("color");
		m.add(color);
		
		JLabel speedLabel = new JLabel("Speed");
		mBottom.add(speedLabel);
		speedSlider = new JSlider(1,speed,rotateSpeed);
		speedSlider.addChangeListener(this);
		speedSlider.setMajorTickSpacing(speed / 10);
		speedSlider.setMinorTickSpacing(speed / 100);
		speedSlider.setPaintTicks(true);
		//speedSlider
		mBottom.add(speedSlider);
		
		JLabel widthLabel = new JLabel("Line Width");
		mBottom.add(widthLabel);
		widthSlider = new JSlider(1,20,10);
		widthSlider.addChangeListener(this);
		widthSlider = new JSlider(1,20,10);
		widthSlider.addChangeListener(this);
		widthSlider.setMajorTickSpacing(widthSlider.getMaximum() / 10);
		widthSlider.setMinorTickSpacing(widthSlider.getMaximum() / 50);
		widthSlider.setPaintTicks(true);
		mBottom.add(widthSlider);
		
		t = new Timer(10,this);
		ti = new Timer(10,this);
		t.setActionCommand("timer");
		ti.setActionCommand("rotatecc");

		getContentPane().add(m, BorderLayout.NORTH);
		getContentPane().add(line,BorderLayout.CENTER);
		getContentPane().add(mBottom,BorderLayout.SOUTH);
		pack();
	}


	@Override
	/**
	 * actionPerformed method
	 * Each button and timer has a different ActionCommand
	 * Each time Action Event e is fired off, the specific 
	 * ActionCommand in one of the if statements is triggered 
	 * and the specific functions occur
	 */
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals("timer")) {		
			line.getL().rotate(rotateSpeed);
			line.repaint();
		}
		if (command.equals("rotatecc")) {
			line.getL().rotate(rotateSpeed * -1);
			line.repaint();
		}
		
		if (command.equals("rotate")) {
			ti.stop();
			t.start();
		}
		
		if(command.equals("cc")){
			t.stop();
			ti.start();
			
		}
		
		if(command.equals("stop")){
			t.stop();
			ti.stop();
		}
		
		if(command.equals("color")){
			Random rnd = new Random();
			 c = new Color(rnd.nextInt(251) + 0, rnd.nextInt(251) +0, 
					 rnd.nextInt(251) + 0);		 
			 line.repaint();
		}

	}
	
	/**
	 * The main method:
	 * Creates a new Display object, sets that object visible
	 * @param args
	 */
	public static void main(String[] args) {

		Display line = new Display();
		line.setVisible(true);

	

	}

	@Override
	/**
	 * componentResized method:
	 * Saves the current line orientation
	 * Gets the new screen height and width
	 * Creates a new point at that width and height
	 * The new line is drawn with the old start point and the new end point
	 * Rotates the to the previously saved orientation
	 * 
	 */
	public void componentResized(ComponentEvent e) {
		line.orientation = line.getL().getOrientation();
		line.height = line.getHeight();
		line.width = line.getWidth();
		line.end = new Point(line.width,line.height);
		line.setL(new Line(line.start,line.end));
		line.getL().rotate(line.orientation);

	}

	@Override
	/**
	 * Must be overridden
	 */
	public void componentHidden(ComponentEvent arg0) {
	}

	@Override
	/**
	 * Must be overridden
	 */
	public void componentMoved(ComponentEvent arg0) {
	}

	@Override
	/**
	 * Must be overridden
	 */
	public void componentShown(ComponentEvent arg0) {
	}
	
	/**
	 * Getter for the color of the line
	 * @return Color of the line "c"
	 */
	public static Color getC(){
		return c;
	}
	
	/**
	 * Setter for the color of the line so that it can be modified
	 * @param Color of the line "c"
	 */
	public static void setC(Color c){
		Display.c = c;
	}

	@Override
	/**
	 * stateChanged method:
	 * Utilizes a changeListener and changeEvent for the speed and width sliders
	 * Line is repainted after the change in speed or width is made
	 * 
	 */
	public void stateChanged(ChangeEvent c) {
		rotateSpeed = speedSlider.getValue(); //
		rotateSpeed = speedSlider.getValue();// + 1 prevents 0 delay which is ugly
		line.stroke = new BasicStroke(widthSlider.getValue());
		line.repaint();
	}

}