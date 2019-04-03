package edu.macalester.comp124.wordcounter;


/**
 * A counter that keeps track of counts for all words
 * 
 * @author shilad
 *
 */
public class AllWordsCounter {

    public static final int MAX_WORDS = 10000;
    private SingleWordCounter[] counters;
    /**
     * Constructor that initializes the SingleWordCounter instance variable
     */
    public AllWordsCounter() {
		counters = new SingleWordCounter[MAX_WORDS];
    }

    /**
     * Returns the number of non-null SingleWordCounter objects in the counters array
     * @return the filled size of the SingleWordcounter array
     */
    public int getNumWords() {
        int distinctWords = 0;
        for (int i=0; i<counters.length; i++){
        	if (counters[i]!=null) {
				distinctWords++;
			}
		}
		return distinctWords;
    }
	
	/**
	 * Increment the count for the specified word.  Remember that this may
     * be the first time the word counter has seen this particular word.
	 * 
	 * @param word
	 */
	public void incrementCountForWord(String word) {
        if(word.equals("")){
			return;
        }
        for (int i=0; i < counters.length; i++) {
			if (counters[i]!=null && counters[i].wordMatches(word)) {
				counters[i].incrementCount();
				return;
			} else if (counters[i]==null) {
				SingleWordCounter newWord = new SingleWordCounter(word);
				newWord.incrementCount();
				counters[i] = newWord;
				return;
			}
        }
	}

	/**
	 * Return the count for the particular word.  Remember that the
	 * word may not have been seen before.
	 * @param word
	 * @return
	 */
	public int getCount(String word) {
        // Make sure to return 0 for words you haven't seen before.
		if(word.equals("")) {
			return -1;
		}
		for (int i=0; i < counters.length; i++) {
			if (counters[i]!=null && counters[i].wordMatches(word)) {
				return counters[i].getCount();
			} else if (counters[i]==null){
				return 0;
			}
		}
		return -2;
	}
	
	/**
	 * @return The an array of all words that have been counted
	 * (just the words, not the values).
	 */
	public String []  getAllWords() {
        int n = getNumWords();
        String[] words = new String[n];

		for (int i=0; i<counters.length; i++){
			if (counters[i]!=null) {
				words[i] = counters[i].getWord();
			} else {
				break;
			}
		}
        return words;
	}
}
















