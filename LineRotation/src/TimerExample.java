import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

public class TimerExample extends JFrame implements ActionListener {
	JButton toggle = new JButton();
	Timer timer = new Timer(100, this);

	/**
	 * 
	 */
	private static final long serialVersionUID = 3401640005294654209L;

	private int counter;
	TimerExample()
	{
		timer.setActionCommand("timer");
		toggle.addActionListener(this);
		toggle.setActionCommand("toggle");
		
		
		//Action Listener
		getContentPane().add(toggle);
		pack();
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		Boolean isRunning = false;
	String command = e.getActionCommand();
	if(e.equals("toggle"))
	{
		if(isRunning)
		{
		timer.stop();
		isRunning = false;
		}
		
		if(!isRunning)
		{
			timer.start();
			isRunning = true;
		}
		
	}
	}
	public static void main(String[] args)
	{
		TimerExample test = new TimerExample();
		test.setVisible(true);
	}
}