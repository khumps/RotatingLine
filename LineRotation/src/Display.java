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

public class Display extends JFrame implements ActionListener,
		ComponentListener, ChangeListener {

	/**
	 * 
	 */
	private static Color c = new Color(0,0,0);
	private static final long serialVersionUID = 454055181523406363L;
	Timer t;	//clockwise timer
	Timer ti; // counter-clockwise timer
	LineDisplay line = new LineDisplay();
	int speed = 10;
	JSlider speedSlider;
	JSlider widthSlider;
	

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
		speedSlider = new JSlider(1,speed,speed / 2);
		speedSlider.addChangeListener(this);
		mBottom.add(speedSlider);
		
		JLabel widthLabel = new JLabel("Line Width");
		mBottom.add(widthLabel);
		widthSlider = new JSlider(1,20,10);
		widthSlider.addChangeListener(this);
		mBottom.add(widthSlider);
		
		t = new Timer(speedSlider.getValue(),this);
		ti = new Timer(speedSlider.getValue(),this);
		t.setActionCommand("timer");
		ti.setActionCommand("rotatecc");

		getContentPane().add(m, BorderLayout.NORTH);
		getContentPane().add(line,BorderLayout.CENTER);
		getContentPane().add(mBottom,BorderLayout.SOUTH);
		pack();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals("timer")) {			
			line.getL().rotate(1);
			line.repaint();
		}
		if (command.equals("rotatecc")) {
			line.getL().rotate(-1);
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

	public static void main(String[] args) {

		Display line = new Display();
		line.setVisible(true);

	

	}

	@Override
	public void componentResized(ComponentEvent e) {
		line.orientation = line.getL().getOrientation();
		line.height = line.getHeight();
		line.width = line.getWidth();
		line.end = new Point(line.width,line.height);
		line.setL(new Line(line.start,line.end));
		line.getL().rotate(line.orientation);

	}

	@Override
	public void componentHidden(ComponentEvent arg0) {
	}

	@Override
	public void componentMoved(ComponentEvent arg0) {
	}

	@Override
	public void componentShown(ComponentEvent arg0) {
	}
	
	public static Color getC(){
		return c;
	}
	
	public static void setC(Color c){
		Display.c = c;
	}

	@Override
	public void stateChanged(ChangeEvent c) {
		t.setDelay(speed - speedSlider.getValue() + 1); //
		ti.setDelay(speed - speedSlider.getValue() + 1);// + 1 prevents 0 delay which is ugly
		line.stroke = new BasicStroke(widthSlider.getValue());
		line.repaint();
	}

}
