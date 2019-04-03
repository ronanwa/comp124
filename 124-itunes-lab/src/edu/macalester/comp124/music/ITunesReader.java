package edu.macalester.comp124.music;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A class that reads an iTunes library xml file (format shown below).
 *
 * A reader can read through an xml file exactly once.
 * Each call to readNextSong() returns the next unread song in the xml file.
 * When all the songs have been returned, readNextSong() returns null.
 *
 * The file format is approximately:
 *
 <pre>
 <plist version="1.0">
     <dict>
         <key>Major Version</key><integer>1</integer>

            ... a bunch of other header keys ...

         <key>Tracks</key>
         <dict>

             <key>1191</key>
             <dict>
                 <key>Track ID</key><integer>1191</integer>
                 <key>Name</key><string>April In Paris</string>
                 <key>Artist</key><string>Charlie Parker</string>
                 <key>Album</key><string>With Strings: The Master Takes</string>
                 <key>Total Time</key><integer>193044</integer>
                ... other unused fields ...
            </dict>

            <key>1193</key>
            <dict>
                <key>Track ID</key><integer>1193</integer>
                <key>Name</key><string>Autumn In New York</string>
                <key>Artist</key><string>Charlie Parker</string>
                <key>Album</key><string>With Strings: The Master Takes</string>
                ... other unused fields ...
            </dict>

            ... many more songs ...

        </dict>
      </dict>
 </plist>
 </pre>
 * 
 * @author shilad
 */
public class ITunesReader {
	private static final Pattern REGEX = Pattern.compile(".*<key>([^<]+)</key><.*?>([^<]+)</.*?>"); 
	private BufferedReader reader;
	
	/**
	 * Construct a new iTunes reader.
	 * @param path
	 */
	public ITunesReader(String path) {
		try {
			reader = new BufferedReader(new FileReader(path));
		} catch (FileNotFoundException e) {
            throw new RuntimeException(e);
		}
	}
	
	/**
	 * Reads the next media object from the stream and returns it.
	 * Returns null when all entries have been read.
	 * @return The next unread song for the file, or null if all the songs have been read.
	 */
	public Song readNextSong() {
		if (reader == null) {
			return null;
		}

        // accumulator variables for the next song.
		String song = null;
		String artist = null;
		String location = null;
		String album = null;
		int count = 0;

        // Read lines associated with the next song into the accumulator variables
		while (true) {
			String line;
			try {
				line = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				reader = null;
				return null;
			}
			if (line == null) {
				reader = null;
				return null;
			}
			
			// Are we done reading the song?
			if (song != null && line.trim().equals("</dict>")) {
				break;
			}

            // Check to see if the next line is associated with one of the accumulator variables
			Matcher m = REGEX.matcher(line);
			if (m.matches()) {
				String field = m.group(1);
				String value = m.group(2);
				if (field.equals("Name")) {
					song = value;
				} else if (field.equals("Artist")) {
					artist = value;
				} else if (field.equals("Album")) {
					album = value;
				} else if (field.equals("Location")) {
					location = value;
				} else if (field.equals("Play Count")) {
					count = Integer.valueOf(value);
				}
			}
		}

        // TODO: Replace the return null line below with the line that follows it once Song is complete.
        return new Song(location, artist, album, song, count);
    }
}
