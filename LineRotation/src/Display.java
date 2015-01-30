import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Display extends JPanel {
	
	public void drawing(){
		repaint();
	}
	
	public void paintComponent(Graphics g){
		g.setColor(Color.BLUE);
		g.drawLine(0,0,400,400);
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame("Line Rotator");
		f.setVisible(true);
		f.setPreferredSize(new Dimension(400,400));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints g = new GridBagConstraints();
		g.gridheight = 1;
		g.gridwidth = 1;
		g.insets = new Insets(0,0,0,0);
		
		JButton rotate = new JButton("Rotate Clockwise");
		g.gridx = 0;
		g.gridy = 0;
		panel.add(rotate, g);
		
		JButton rotatecc = new JButton("Rotate Counter - Clockwise");
		g.gridx = 1;
		g.gridy = 0;
		panel.add(rotatecc, g);
		
		JButton stop = new JButton("Stop");
		g.gridx = 2;
		g.gridy = 0;
		panel.add(stop, g);
		
		Display line = new Display();
		f.getContentPane().add(line, BorderLayout.CENTER);
		f.getContentPane().add(panel, BorderLayout.NORTH);
		f.pack();
		
		class Rotate implements ActionListener{
			public void actionPerformed(ActionEvent e){
				JFrame f = new JFrame("ClockWise");
				f.setVisible(true);
				f.setSize(200,50);
				
			}
		}
		
		rotate.addActionListener(new Rotate());
		
		class RotateCC implements ActionListener{
			public void actionPerformed(ActionEvent e){
				JFrame f = new JFrame("Counter ClockWise");
				f.setVisible(true);
				f.setSize(200,50);
			}			
		}
		
		rotatecc.addActionListener(new RotateCC());
		
		class Stop implements ActionListener{
			public void actionPerformed(ActionEvent e){
				JFrame f = new JFrame("Stop");
				f.setVisible(true);
				f.setSize(200,50);
			}
		}
		
		stop.addActionListener(new Stop());
	}
}

