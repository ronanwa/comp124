package edu.macalester.comp124.wordcounter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Interesting word finder.
 * To use this class, first call countWords(), then call findDistinctive.
 *
 * @author shilad
 *
 */
public class DistinctiveWordFinder {
	// Word counts from each file.
	private AllWordsCounter primaryCounts;
	private AllWordsCounter secondaryCounts;
	
	/**
	 * Constructs a new word counter.
	 */
	public DistinctiveWordFinder() {
        primaryCounts = new AllWordsCounter();
        secondaryCounts = new AllWordsCounter();
	}
	
	/**
	 * Counts the words in two files.
	 * @param primaryFile
	 * @param secondaryFile
	 * @throws java.io.IOException
	 */
	public void countWords(File primaryFile, File secondaryFile) {
		countWordsInOneFile(primaryFile, primaryCounts);
		countWordsInOneFile(secondaryFile, secondaryCounts);
	}

	/**
	 * Counts the words in a single file.  The counts should be tallied
	 * in the passed-in counts object.
	 *
	 * @param file1
	 * @param counter
	 * @throws java.io.IOException
	 */
	private void countWordsInOneFile(File file1, AllWordsCounter counter){
		try {
            BufferedReader r = new BufferedReader(new FileReader(file1));
            while (true) {
                String line = r.readLine();
                if (line == null) {
                    break;
                }
                for (String w : splitLine(line)) {
                    counter.incrementCountForWord(w);
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
	}
	
	/**
	 * Find and display words in the primary word counter that are interesting.
	 * Use System.out.println() to print out information about the interesting
	 * words.
	 */
	public WordScore[] findDistinctive() {
        String[] words = primaryCounts.getAllWords();

        // This array will be used to sort the word scores;
        WordScore[] scores = new WordScore[words.length];

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            // the primaryCounts and secondaryCounts instance variables.
            int primary = primaryCounts.getCount(word);
            int secondary = secondaryCounts.getCount(word);

            // Calculate the interestingness score and prepare it in the output queue
            double score = getDistinctiveScore(primary, secondary);
            scores[i] = new WordScore(word, score);
        }

        Arrays.sort(scores);

        return scores;
	}

    /**
     * Displays the distinctive wordscores
     * @param scores in sorted order from most interesting to least.
     */
    public void displayDistinctive(WordScore[] scores){
        for (int i = 0; i < 20; i++) {
            String word = scores[i].getWord();
            int c1 = primaryCounts.getCount(word);
            int c2 = secondaryCounts.getCount(word);
            System.out.println("word: " + word + ", primary=" + c1 + ", secondary=" + c2 + ", score="+scores[i].getScore());
        }
    }

    /**
     * Returns a "score" indicating how interesting a word is.
     * @param primaryCount  The count for a specific word for the primary candidate (i.e. Trump)
     * @param secondaryCount The count for a specific word for the secondary candidate (i.e. Clinton)
     * @return
     */
    private double getDistinctiveScore(int primaryCount, int secondaryCount) {
		return ((primaryCount) / (secondaryCount + primaryCount + 1.0));
    }

	/**
	 * Splits a line into words.
	 * @param line
	 * @return An array containing the words.
	 */
	private String[] splitLine(String line) {
		return line.split("[^a-zA-Z0-9']+");
	}
	
	public static void main(String args[]) {
        File f1 = new File("C:\\Users\\ronan\\Desktop\\COMP124-F18\\124-word-counter\\dat\\trump.txt");
        File f2 = new File("C:\\Users\\ronan\\Desktop\\COMP124-F18\\124-word-counter\\dat\\hillary.txt");

        System.out.println("Donald Trump's Distinctive Words:");
		DistinctiveWordFinder finder = new DistinctiveWordFinder();
		finder.countWords(f1, f2);
		WordScore[] scores = finder.findDistinctive();
        finder.displayDistinctive(scores);

        System.out.println("\nHillary Clinton's Distinctive Words:");
        finder = new DistinctiveWordFinder();
        finder.countWords(f2, f1);
        scores = finder.findDistinctive();
        finder.displayDistinctive(scores);
	}
}
