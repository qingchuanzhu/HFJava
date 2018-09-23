import java.io.*;
import java.util.*;

class Jukebox1 {

	ArrayList<Song> songList = new ArrayList<Song>();

	void go() {
		getSongs();
		System.out.println(songList);
		ArtistComparator artistCompare = new ArtistComparator();
		Collections.sort(songList, artistCompare);
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
		Song nextSong = new Song(tokens[0], tokens[1], tokens[2], tokens[3]);
		songList.add(nextSong);
	}

	public static void main(String[] args) {
		new Jukebox1().go();
	}
}

class Jukebox2 extends Jukebox1{

	void go() {
		getSongs();
		System.out.println(songList);
		Collections.sort(songList);
		System.out.println(songList);

		HashSet<Song> songSet = new HashSet<Song>();
		songSet.addAll(songList);
		System.out.println(songSet);
	}

	public static void main(String[] args) {
		new Jukebox2().go();
	}
}