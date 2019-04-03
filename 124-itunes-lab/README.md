Comp 124 - iTunes Lab
========

## Part 1: Preparation

1. Fork this repo and clone your fork of this repo using VCS-checkout
2. Import into Intellij using new->module from existing. Be sure to choose the 124-itunes.iml file

## Part 2: Complete the Media Class

The Media class should have the following instance variables (you must edit the code and make them):

  * filePath (a String)
  * name (a String)
  * count (an int)
  
Remember, instance variables should almost always be declared private and their name should start with a lowercase letter.

Part A: Complete the basic elements of the Media class (1 passing test)

1. Add the instance variables to the Media class.
2. Create a constructor for the Media class that takes parameters for all three attributes above and initializes the object appropriately.
3. Create getters (but not setters) for all three instance variables in the Media class.
4. Uncomment the matchesQuery() method in the Media class.  Note: In IntelliJ editor, command-/ or control-/ will toggle commenting on a selected region of code)
5. Uncomment all the Java code lines in Song.java (leave the Javadoc comments `/** ... */` intact)
6. Uncomment the testBasic() method in the TestMedia class. It should pass. You MUST NOT change any of the tests.

Part B: Complete the two-argument constructor  (2 passing tests)

1. Create a two-argument Media constructor by chaining to the three-argument constructor, and passing 0 (a reasonable default value) for count.
2. Uncomment and run the testTwoArgumentConstructor(). It should pass.

Part C: Complete the toString() method (4 passing tests)

1. Complete a reasonable toString() method. At the very least, it should contain the filePath and name.
2. Uncomment the equals() method for Media (I have already completed it for you). Study the method. Two songs are equal if they have the same filepath and name, but their counts do not matter.
3. Uncomment and run testToString() and testEqualsMethod. They should both pass.

## Part 3: Complete the Song Class

The song class is a child class of the Media class, and it has two additional variables:

 * artist (A String)
 * album (A String)


2. Add a reasonable toString method. It should include the elements of Media's toString plus the artist and album.
3. In ITunesReader.java, remove the `return null` line at the end of the file and uncomment the `return new Song(...)` line.
4. Uncomment and run testToString() in TestSong.java. It should pass.

## Part 4: Complete the Music Searcher Class
The goal of this step is to change the MusicSearcher class so that it reads a search query from the user and prints out the matching items in; the library.  MusicSearcher should repeat this process until the user types "stop."

Your MusicSearch should summarize the itunes library, then repeatedly prompt the user to search their iTunes library. For example:

```
popular song: media: Supercalifragilisticexpialidocious at file://localhost/Users/shilad/Music/iTunes/iTunes%20Music/Harry%20Connick,%20Jr_/Songs%20I%20Heard/01%20Supercalifragilisticexpialidocious.mp3 with count 101 by artist Harry Connick, Jr. on album Songs I Heard
popular song: media: Weak at file://localhost/Users/shilad/Music/iTunes/iTunes%20Music/Gretchen%20Parlato/In%20a%20Dream%20(iTunes%20Bonus%20Track%20Edition)/10%20Weak.m4a with count 177 by artist Gretchen Parlato on album In a Dream (iTunes Bonus Track Edition)
popular song: media: Clean White Noise . Nature Sounds and Natural Soothing Music to Calm and Relax at file://localhost/Users/shilad/Music/iTunes/iTunes%20Music/Newborn%20Babies%20Natural%20White%20Noise/Newborn%20Sleep%20Aid%20-%20Sleeping%20Music%20and%20Sleep%20Sounds.%20Soothing%20Relaxing%20Music,%20Natural%20White%20Noise,%20Nature%20Sounds,%20Birds,%20Waterfalls%20and%20Sound%20of%20Rain%20for%20Sleeping%20Baby%20and%20Babies%20Sleeping/26%20Clean%20White%20Noise%20.%20Nature%20Sounds%20and%20Natural%20Soothing%20Music%20to%20Calm%20and%20Relax.m4a with count 233 by artist Newborn Babies Natural White Noise on album Newborn Sleep Aid - Sleeping Music and Sleep Sounds. Soothing Relaxing Music, Natural White Noise, Nature Sounds, Birds, Waterfalls and Sound of Rain for Sleeping Baby and Babies Sleeping
num songs: 3166

Enter search query, or "stop" to stop: naima
    results for search "naima":
    matching song: media: Naima at file://localhost/Users/shilad/Music/iTunes/iTunes%20Music/John%20Coltrane/Giant%20Steps/06%20Naima.mp3 with count 1 by artist John Coltrane on album Giant Steps
    matching song: media: Naima Alternate Take at file://localhost/Users/shilad/Music/iTunes/iTunes%20Music/John%20Coltrane/Giant%20Steps/09%20Naima%20Alternate%20Take.mp3 with count 0 by artist John Coltrane on album Giant Steps
    matching song: media: Naima at file://localhost/Users/shilad/Music/iTunes/iTunes%20Music/John%20Coltrane/Giant%20Steps/06%20Naima%201.mp3 with count 2 by artist John Coltrane on album Giant Steps
    matching song: media: Naima Alternate Take at file://localhost/Users/shilad/Music/iTunes/iTunes%20Music/John%20Coltrane/Giant%20Steps/09%20Naima%20Alternate%20Take%201.mp3 with count 0 by artist John Coltrane on album Giant Steps

Enter search query, or "stop" to stop: gnarls
    matching song: media: Crazy at file://localhost/Users/shilad/Music/iTunes/iTunes%20Music/Gnarls%20Barkley/St.%20Elsewhere/02%20Crazy.m4a with count 5 by artist Gnarls Barkley on album St. Elsewhere
```

1. As a baby step, write a method called `summarize` in MusicSearcher that iterates over all media objects in the library and summarizes information about them. 

ITunesReader objects provide access to the media objects, and it functions like an iterator. Conceptually, you can think of it having a list of song information with a placeholder pointing at the first song in the list. Each time the `readNextSong` method is called, the placeholder moves to the next song in the list and returns the song that it was previously bookmarking. Look carefully at the method to see how to determine when you have reached the last song.

    * Call `summarize()` from the MusicSearcher constructor (that's all that should be there for now).
    * Create a new ITunesReader object.  The path of the file is specified by the class variable PATH.
    * Using the ITunesReader object, loop over all media objects (hint: one of the two looping patterns we learned in class will work well).
    * Count the total number of songs - you should get 3166.
    * Print out all the songs that have a play count greater than or equal to 100 - you should see 3 songs.

2. Write the loop to repeatedly ask the user for a search query until they type "stop." (Don't actual do the search method).

3. Write a method called `search` that takes a query (a String) and print out songs that match the query.
Your code should look very much like step 1, except you should only print out songs that match the query (Hint: Song.java has a boolean `matchesQuery()` method).

## Part 5: Fun Stuff
Ideas for other fun optional activities:

* Replace my "iTunes Music Library.xml" file with your own. You may need to get itunes to generate your file for you using [these directions](https://support.apple.com/en-us/HT201610).
* Add the "genre" field to the Song object.  Adjust the ITunesReader so that it parses genres.  Count the number of times "jazz," "rock," "classical," "blues," and "folk" appear.
* Create a PodCast class similar to the Song class.  Adjust iTunesReader so that it creates PodCasts or Songs depending on the data in the xml file.  To figure out how to identify the PodCasts in the xml file, look for the "This American Life" podcast in the xml file and study how the xml structure differs from regular songs.
