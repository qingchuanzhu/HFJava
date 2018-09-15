import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class SimpleGui1 implements ActionListener {

	JButton button;
	JFrame frame;

	void changeIt(){

	}

	void go() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		button = new JButton("change colors");
		button.addActionListener(this);

		MyDrawPanel drawPanel = new MyDrawPanel();

		
		frame.getContentPane().add(BorderLayout.SOUTH, button);
		frame.getContentPane().add(BorderLayout.CENTER, drawPanel);

		frame.setSize(300, 300);
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent event) {
		frame.repaint();
	}

	public static void main(String[] args) {
		SimpleGui1 gui = new SimpleGui1();
		gui.go();
	}
}