import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Display extends JFrame implements ActionListener,
		ComponentListener {

	/**
	 * 
	 */
	private static Color c = new Color(0, 0, 0);
	private static final long serialVersionUID = 454055181523406363L;
	int speed = 20;
	Timer t = new Timer(10, this);
	Timer ti = new Timer(10, this);
	LineDisplay line = new LineDisplay();

	Display() {

		setDefaultLookAndFeelDecorated(true);
		setVisible(true);
		setMinimumSize(new Dimension(500, 500));
		setPreferredSize(new Dimension(600, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		line.addComponentListener(this);

		t.setActionCommand("timer");
		ti.setActionCommand("rotatecc");

		JMenuBar m = new JMenuBar();

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

		getContentPane().add(m, BorderLayout.NORTH);
		getContentPane().add(line);
		pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals("timer")) {
			line.getL().rotate(1);
			line.repaint();
			System.out.println(line.getL().getEndPoints()[0].toString());
		}
		if (command.equals("rotatecc")) {
			line.getL().rotate(-1);
			line.repaint();
			System.out.println(line.getL().getEndPoints()[0].toString());
		}

		if (command.equals("rotate")) {
			ti.stop();
			t.start();
			System.out.println("rotate");
		}

		if (command.equals("cc")) {
			t.stop();
			ti.start();

		}

		if (command.equals("stop")) {
			t.stop();
			ti.stop();
		}

		if (command.equals("color")) {
			Random rnd = new Random();
			c = new Color(rnd.nextInt(251) + 0, rnd.nextInt(251) + 0,
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
		line.end = new Point(line.width, line.height);
		line.setL(new Line(line.start, line.end));
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

	public static Color getC() {
		return c;
	}

	public static void setC(Color c) {
		Display.c = c;
	}

}
