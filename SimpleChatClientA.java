import javax.swing.*;
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;

class SimpleChatClientA {
	JTextField outgoing;
	PrintWriter writer;
	Socket sock;

	void go() {
		// make GUI, call the setUpNetworking()
		JFrame frame = new JFrame("Ludicrously Simple Chat Client");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel mainPanel = new JPanel();
		outgoing = new JTextField(20);
		JButton sendButton = new JButton("Send");
		sendButton.addActionListener(new SendButtonListener());
		mainPanel.add(outgoing);
		mainPanel.add(sendButton);
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		setUpNetworking();
		frame.setSize(400, 500);
		frame.setVisible(true);
		while (true) {
			
		}
	}

	private void setUpNetworking(){
		// make a Socket, then make a PrintWriter
		try{
			sock = new Socket("127.0.0.1", 5000);
			writer = new PrintWriter(sock.getOutputStream());
			System.out.println("Networking established");
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	// Inner class
	class SendButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent ev){
			try {
				writer.println(outgoing.getText());
				writer.flush();
			} catch(Exception ex){
				ex.printStackTrace();
			}
			outgoing.setText("");
			outgoing.requestFocus();
		}
	}

	public static void main(String[] args) {
		new SimpleChatClientA().go();
	}
}