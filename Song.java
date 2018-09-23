import java.util.*;

class Song implements Comparable<Song>{
	private String title;
	private String artist;
	private String rating;
	private String bpm;

	Song() {
		this("Anonymous", "Anonymous", "0", "0");
	}

	Song(String t, String a, String r, String b) {
		title = t;
		artist = a;
		rating = r;
		bpm = b;
	}

	String getTitle(){
		return title; 
	}

	String getArtist(){
		return artist;
	}

	String getRating(){
		return rating;
	}

	String getBpm(){
		return bpm;
	}

	public String toString() {
		return title + ":" + artist;
	}

	public boolean equals(Object aSong) {
		Song s = (Song)aSong;
		return title.equals(s.getTitle());
	}

	public int hashCode() {
		return title.hashCode();
	}

	public int compareTo(Song s) {
		return title.compareTo(s.getTitle());
	}
}

class ArtistComparator implements Comparator<Song> {
	public int compare(Song one, Song two) {
		return one.getArtist().compareTo(two.getArtist());
	}
}