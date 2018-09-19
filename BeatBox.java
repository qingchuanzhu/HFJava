import java.awt.*;
import javax.swing.*;
import javax.sound.midi.*;
import java.util.*;
import java.awt.event.*;
import java.io.*;

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
		// Build up frame and background panel
		theFrame = new JFrame("Cyber BeatBox");
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BorderLayout layout = new BorderLayout();
		JPanel background = new JPanel(layout); // panel for grid, name labels and buttons
		background.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

		// checkbox Grid
		checkboxList = new ArrayList<JCheckBox>();
		GridLayout grid = new GridLayout(16, 16);
		grid.setVgap(0);
		grid.setHgap(2);
		mainPanel = new JPanel(grid);

		for (int i = 0; i < 256; i++){
			JCheckBox c = new JCheckBox();
			c.setSelected(false);
			checkboxList.add(c);
			mainPanel.add(c);
		}

		// Name box
		Box nameBox = new Box(BoxLayout.Y_AXIS);
		for (int i =0; i< 16; i++) {
			nameBox.add(new Label(instrumentNames[i]));
		}

		//button box
		Box buttonBox = new Box(BoxLayout.Y_AXIS);

		JButton start = new JButton("Start");
		start.addActionListener(new MyStartListener());
		buttonBox.add(start);

		JButton stop = new JButton("Stop");
		stop.addActionListener(new MyStopListener());
		buttonBox.add(stop);

		JButton upTempo = new JButton("Tempo Up");
		upTempo.addActionListener(new MyUpTempoListener());
		buttonBox.add(upTempo);

		JButton downTempo = new JButton("Tempo Down");
		downTempo.addActionListener(new MyDownTempoListenre());
		buttonBox.add(downTempo);

		JButton sendButton = new JButton("Serialzelt");
		sendButton.addActionListener(new MySendListener());
		buttonBox.add(sendButton);

		JButton restoreButton = new JButton("Restore");
		restoreButton.addActionListener(new MyReadInListener());
		buttonBox.add(restoreButton);

		// Add Each components to background panel
		background.add(BorderLayout.EAST, buttonBox);
		background.add(BorderLayout.WEST, nameBox);
		background.add(BorderLayout.CENTER, mainPanel);

		// Set up Midi
		setUpMidi();

		theFrame.getContentPane().add(background);

		theFrame.setBounds(50, 50, 300, 300);
		theFrame.pack();
		theFrame.setVisible(true);
	}

	// Midi setup
	void setUpMidi() {
		try {
			player = MidiSystem.getSequencer();
			player.open();
			sequence = new Sequence(Sequence.PPQ, 4);
			track = sequence.createTrack();
			player.setTempoInBPM(120);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	// track build and start
	void buildTrackAndStart() {
		int[] trackList = null;
		sequence.deleteTrack(track);
		track = sequence.createTrack();
		for (int i = 0; i < 16; i++) {
			trackList = new int[16];
			int key = instruments[i];
			for (int j = 0; j < 16; j++) {
				JCheckBox jc = checkboxList.get(j + 16 * i);
				if (jc.isSelected()) {
					trackList[j] = key;
				} else {
					trackList[j] = 0;
				}
			}

			makeTracks(trackList);
		}

		try {
			player.setSequence(sequence);
			player.setLoopCount(player.LOOP_CONTINUOUSLY);
			player.start();
		} catch (Exception ex){

		}
	}

	// Inner class - start button handler
	class MyStartListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			buildTrackAndStart();
		}	
	}

	// Inner class - stop button handler
	class MyStopListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			player.stop();
		}
	}

	// Inner class - UpTempo handler
	class MyUpTempoListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			float tempoFactor = player.getTempoFactor();
			player.setTempoFactor((float)(tempoFactor * 1.03));
		}
	}

	// Inner class - DownTempo handler
	class MyDownTempoListenre implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			float tempoFactor = player.getTempoFactor();
			player.setTempoFactor((float)(tempoFactor * 0.97));	
		}
	}

	// Inner class - Serialzie handler
	class MySendListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			JFileChooser fileSave = new JFileChooser();
			fileSave.showSaveDialog(theFrame);
			saveFile(fileSave.getSelectedFile());
		}
	}

	// Inner class - Restore handler
	class MyReadInListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			JFileChooser fileOpen = new JFileChooser();
			fileOpen.showOpenDialog(theFrame);
			loadFile(fileOpen.getSelectedFile());
		}
	}

	private void saveFile(File file) {
		boolean[] checkboxState = new boolean[256];
		for (int i = 0; i < 256; i++) {
			JCheckBox check = checkboxList.get(i);
			if (check.isSelected()) {
				checkboxState[i] = true;
			}
		}

		try {
			FileOutputStream fileStream = new FileOutputStream(file);
			ObjectOutputStream os = new ObjectOutputStream(fileStream);
			os.writeObject(checkboxState);
		} catch(Exception ex){
			ex.printStackTrace();
		}
	}

	private void loadFile(File file) {
		boolean[] checkboxState = null;
		try {
			FileInputStream fileIn = new FileInputStream(file);
			ObjectInputStream is = new ObjectInputStream(fileIn);
			checkboxState = (boolean[])is.readObject();
		} catch(Exception ex){
			ex.printStackTrace();
		}

		for (int i=0; i < 256; i++) {
			JCheckBox check = checkboxList.get(i);
			if (checkboxState[i]) {
				check.setSelected(true);
			} else {
				check.setSelected(false);
			}
		}
		player.stop();
		buildTrackAndStart();
	}

	// Helper method makeTrack
	void makeTracks(int[] list) {
		for (int i = 0; i < 16; i++) {
			int key = list[i];
			if (key != 0) {
				track.add(makeEvent(144, 9, key, 100, i));
				track.add(makeEvent(128, 9, key, 100, i + 1));
			}
		}
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