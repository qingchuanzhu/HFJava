import javax.sound.midi.*;

class MiniMiniMusicApp {
	void play() {
		try {
			Sequencer player = MidiSystem.getSequencer();
			player.open();

			Sequence seq = new Sequence(Sequence.PPQ, 4);

			Track track = seq.createTrack();

			ShortMessage first = new ShortMessage();
			first.setMessage(192, 1, 70, 0);
			MidiEvent changeIns = new MidiEvent(first, 1);
			track.add(changeIns);

			ShortMessage a = new ShortMessage();
			a.setMessage(144, 1, 64, 100);
			MidiEvent noteOn = new MidiEvent(a, 1);
			track.add(noteOn);

			ShortMessage b = new ShortMessage();
			b.setMessage(128, 1, 64, 100);
			MidiEvent noteOff = new MidiEvent(b, 14);
			track.add(noteOff);

			player.setSequence(seq);
			player.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		MiniMiniMusicApp mini = new MiniMiniMusicApp();
		mini.play();
	}
}