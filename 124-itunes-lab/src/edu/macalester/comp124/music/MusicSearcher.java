package edu.macalester.comp124.music;

import java.util.Scanner;

/**
 * Searches the "iTunes Music Library.xml" file for a query.
 */
public class MusicSearcher extends Media {


	public static final String PATH = "C:\\Users\\ronan\\Desktop\\COMP124-F18\\124-itunes-lab\\res\\iTunes Music Library.xml";

	/**
	 * Constructor to create a music searcher object.
	 */
	public MusicSearcher() {
	}

	/**
	 * Main method to start the program. Does not need to be modified for this lab.
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		MusicSearcher searcher = new MusicSearcher();
		summarize();
		search();
	}

	public static void summarize() {

		ITunesReader object = new ITunesReader(PATH);
		Boolean answer = true;
		int total = 0;
		while (answer == true) {
			Song song = object.readNextSong();
			if (song == null) {
				break;
			}
			total += 1;
			if (song.getCount() >= 100) {
				System.out.println(song.getName());
			}
		}
		System.out.println(total);
	}

	public static void search() {
		Scanner reader = new Scanner(System.in);
		ITunesReader object = new ITunesReader(PATH);
		Boolean answer = true;
		while (answer == true) {
			System.out.println("What song do you want to find? ");
			String songChoice = reader.nextLine();
			Song song = object.readNextSong();
			if (song.matchesQuery(songChoice)){
				System.out.println(song);
			} else {
				System.out.println("Song not available.");
			}
		}
	}
}
