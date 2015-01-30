import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Display {
	public static void main(String[] args) {
		JFrame f = new JFrame("Line Rotator");
		f.setVisible(true);
		f.setPreferredSize(new Dimension(400,400));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GridBagConstraints g = new GridBagConstraints();
		g.gridheight = 1;
		g.gridwidth = 1;
		g.insets = new Insets(10,10,10,10);
		
		JButton start = new JButton("Start");
		g.gridx = 0;
		g.gridy = 0;
		JPanel panel = new JPanel(new GridBagLayout());
		panel.add(start, g);
		f.getContentPane().add(panel, BorderLayout.NORTH);	
		f.pack();
	}
}
