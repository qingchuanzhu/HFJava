import java.io.*;
import java.util.*;

class Jukebox1 {

	ArrayList<String> songList = new ArrayList<String>();

	void go() {
		getSongs();
		System.out.println(songList);
	}

	void getSongs() {
		try {
			File file = new File("SongList.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = reader.readLine()) != null) {
				addSong(line);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	void addSong(String lineToParse) {
		String[] tokens = lineToParse.split("/");
		songList.add(tokens[0]);
	}

	public static void main(String[] args) {
		new Jukebox1().go();
	}
}