import java.awt.*;
import javax.swing.*;
import javax.sound.midi.*;
import java.util.*;
import java.awt.event.*;

class BeatBox {
	// GUI instance variables
	JFrame theFrame;
	JPanel mainPanel;
	ArrayList<JCheckBox> checkboxList;
	String[] instrumentNames = {"Bass Drum", "Closed Hi-Hat", "Open Hi-Hat", "Acoustic Snare", 
	"Crash Cymbal", "Hand Clap", "High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Conga",
	"CowBell", "Vibraslap", "Low-mid Tom", "High Agogo", "Open Hi Conga"};
	int[] instruments = {35, 42, 46, 38, 49, 39, 50, 60, 70, 72, 64, 56, 58, 47, 67, 63};

	// Midi instance variables
	Sequencer player;
	Sequence sequence;
	Track track;

	// build GUI
	void buildGUI() {
		theFrame = new JFrame("Cyber BeatBox");
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BorderLayout layout = new BorderLayout();
		JPanel background = new JPanel(layout);
		background.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

		theFrame.getContentPane().add(background);

		theFrame.setBounds(50, 50, 300, 300);
		theFrame.pack();
		theFrame.setVisible(true);
	}

	// Midi setup
	void setUpMidi() {

	}

	// track build and start
	void buildTrackAndStart() {

	}

	// Inner class - start button handler
	class MyStartListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {

		}	
	}

	// Inner class - stop button handler
	class MyStopListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			
		}
	}

	// Inner class - UpTempo handler
	class MyUpTempoListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			
		}
	}

	// Inner class - DownTempo handler
	class MyDownTempoListenre implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			
		}
	}

	// Helper method makeTrack
	void makeTracks(int[] list) {

	}

	// Helper method makeEvent
	static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick){
		MidiEvent event = null;
		try {
			ShortMessage a = new ShortMessage();
			a.setMessage(comd, chan, one, two);
			event = new MidiEvent(a, tick);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return event;
	}

	// Main
	public static void main(String[] args) {
		new BeatBox().buildGUI();
	}
}