import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Display extends JFrame implements ActionListener{
	
	int speed = 20;
	private static Color c = new Color(0,0,0);
	Timer t = new Timer(20,this);
	LineDisplay line = new LineDisplay();
	
	Display(){
		
		final JFrame f = new JFrame("Line Rotator");	
		setDefaultLookAndFeelDecorated(true);
		setVisible(true);
		setMinimumSize(new Dimension(500,500));
		setPreferredSize(new Dimension(600,600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		t.setActionCommand("timer");
		
		JMenuBar m = new JMenuBar();
		JButton rotate = new JButton("Rotate Clockwise");
		rotate.addActionListener(this);
		rotate.setActionCommand("rotate");
		m.add(rotate);
		
		JButton rotatecc = new JButton("Rotate Counter - Clockwise");
		rotatecc.setActionCommand("cc");
		m.add(rotatecc);
		
		JButton stop = new JButton("Stop");
		stop.setActionCommand("stop");
		m.add(stop);
		
		JButton color = new JButton("Change Color");
		color.setActionCommand("color");
		m.add(color);
		
		JButton help = new JButton("Help");
		help.setActionCommand("help");
		m.add(help);
		
		
		getContentPane().add(m, BorderLayout.NORTH);
		getContentPane().add(line);
		pack();
	}
	
	public void drawLine(){
		repaint();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if(command.equals("timer")){
			line.l.rotate(10);
			line.repaint();
			System.out.println("timer");
		}
		if(command.equals("rotate")){
			t.start();
			System.out.println("rotate");
		}
		
	}

	public static void main(String[] args) {
		
		Display line = new Display();
		line.setVisible(true);
		

		
//		class ChangeColor implements ActionListener{
//			public void actionPerformed(ActionEvent e){
//				Random rnd = new Random();
//				c = new Color(rnd.nextInt(251) + 0,rnd.nextInt(251) + 0,rnd.nextInt(251) + 0);
//				f.repaint();
//			}
//		}
		
		
	}




}

