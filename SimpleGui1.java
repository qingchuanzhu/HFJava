import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class SimpleGui1 {

	JFrame frame;
	JLabel label;

	class LabelListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			label.setText("Ouch!");
		}
	}

	class ColorListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			frame.repaint();
		}
	}

	void go() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton colorButton = new JButton("change colors");
		colorButton.addActionListener(new ColorListener());

		JButton labelButton = new JButton("Change Label");
		labelButton.addActionListener(new LabelListener());

		label = new JLabel("I'm a Label");

		MyDrawPanel drawPanel = new MyDrawPanel();
		
		frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
		frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
		frame.getContentPane().add(BorderLayout.EAST, labelButton);
		frame.getContentPane().add(BorderLayout.WEST, label);

		frame.setSize(300, 300);
		frame.setVisible(true);
	}

	

	public static void main(String[] args) {
		SimpleGui1 gui = new SimpleGui1();
		gui.go();
	}
}