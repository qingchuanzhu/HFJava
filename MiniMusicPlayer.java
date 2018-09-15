import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;

class MiniMusicPlayer {

	static JFrame f = new JFrame("My First Music Video");
	static MyDrawPanel ml;

	public static void main(String[] args) {
		MiniMusicPlayer player = new MiniMusicPlayer();
		player.go();	
	}

	void setUpGui() {
		ml = new MyDrawPanel();
		f.setContentPane(ml);
		f.setBounds(30, 30, 300, 300);
		f.setVisible(true);
	}

	public void go() {
		setUpGui();

		try {
			Sequencer player = MidiSystem.getSequencer();
			player.open();

			int[] eventsIWant = {127};
			player.addControllerEventListener(ml, eventsIWant);

			Sequence seq = new Sequence(Sequence.PPQ, 4);

			Track track = seq.createTrack();

			for (int i = 5; i < 61; i += 4) {
				int r = (int)(Math.random() * 50 + 1); 
				track.add(makeEvent(144, 1, r, 100, i));
				track.add(makeEvent(176, 2, 127, 0, i));
				track.add(makeEvent(128, 1, r, 100, i + 2));
			}

			player.setSequence(seq);
			player.setTempoInBPM(220);
			player.start();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick){
		MidiEvent event = null;
		try {
			ShortMessage a = new ShortMessage();
			a.setMessage(comd, chan, one, two);
			event = new MidiEvent(a, tick);
		} catch(Exception ex) {

		}
		return event;
	}

	class MyDrawPanel extends JPanel implements ControllerEventListener{

		boolean msg = false;

		public void controlChange(ShortMessage event) {
			msg = true;
			repaint();	
		}

		public void paintComponent(Graphics g) {
			if (msg) {
				int red = (int)(Math.random() * 256);
				int green = (int)(Math.random() * 256);
				int blue = (int)(Math.random() * 256);
				
				g.setColor(new Color(red, green, blue));

				int ht = (int)(Math.random() * 120 + 10);
				int width = (int)(Math.random() * 120 + 10);

				int x = (int)(Math.random() * 40 + 10);
				int y = (int)(Math.random() * 40 + 10);

				g.fillRect(x, y, ht, width);
				msg = false;
			}
		}
	}
}