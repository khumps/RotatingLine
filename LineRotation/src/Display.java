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
import javax.swing.JMenuBar;
import javax.swing.JPanel;


public class Display extends JPanel {
	
	static int frameWidth = 800;
	static int frameHeight = 600;
	
	public int getFrameWidth() {
		return frameWidth;
	}

	public void setFrameWidth(int frameWidth) {
		this.frameWidth = frameWidth;
	}

	public int getFrameHeight() {
		return frameHeight;
	}

	public void setFrameHeight(int frameHeight) {
		this.frameHeight = frameHeight;
	}

	public void drawing(){
		repaint();
	}
	
	public void paintComponent(Graphics g){
		g.setColor(Color.BLUE);
		g.drawLine(0,0,frameWidth,frameHeight - 50);

	}
	
	public static void main(String[] args) {
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame f = new JFrame("Line Rotator");
		f.setResizable(false);
		f.setVisible(true);
		f.setPreferredSize(new Dimension(frameWidth,frameHeight));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p = new JPanel(new GridBagLayout());

		GridBagConstraints g = new GridBagConstraints();
		g.gridheight = 1;
		g.gridwidth = 1;
		g.insets = new Insets(0,0,0,0);
		
		JMenuBar m = new JMenuBar();
		JButton rotate = new JButton("Rotate Clockwise");
		m.add(rotate);

		JButton rotatecc = new JButton("Rotate Counter - Clockwise");
		m.add(rotatecc);
		
		JButton stop = new JButton("Stop");
		m.add(stop);
		
		JButton help = new JButton("Help");
		m.add(help);
		
		Display line = new Display();
		f.getContentPane().add(line, BorderLayout.CENTER);
		f.getContentPane().add(m, BorderLayout.NORTH);
		f.getContentPane().add(p, BorderLayout.SOUTH);
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
		
		class Help implements ActionListener{
			public void actionPerformed(ActionEvent e){
				JFrame f = new JFrame("Help");
				f.setVisible(true);
				f.setSize(300,300);

			}
		}
		
		help.addActionListener(new Help());
	}
}

