// Ryan Hasty
// Project 2
// Operable GUI for top 10 weekly netflix shows

package project1;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
public class MainFrame {

	public static void main(String[] args) {
		JFrame frame = new JFrame("NETFLIX TOP10");
	    frame.setPreferredSize(new Dimension(800, 500));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 500);

		MainPanel myPanel = new MainPanel();

		frame.getContentPane().add(myPanel);
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				myPanel.doClose();
			}
		});
	}
}