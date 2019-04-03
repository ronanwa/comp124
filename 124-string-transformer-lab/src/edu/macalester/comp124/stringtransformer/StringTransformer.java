package edu.macalester.comp124.stringtransformer;

import java.util.Scanner;

/**
 * A StringTransformer applies some transformation to a string, or to each word within a string.
 * Subclasses should override the transform() method.
 * 
 * @author Paul
 */
public abstract class StringTransformer {
    
    /**
     * Apply some transformation to the input string, and return the result.
     */
    public abstract String transform(String s);
    
    /**
     * The UI uses toString() for the description, so subclasses must override it. 
     */
    public abstract String toString();
    
    /**
     * Returns a copy of the input string with each word (that is, each subsequence of letters)
     * passed through transform(), and all non-letter characters left intact.
     */
    public String transformEachWord(String in) {
        Scanner wordScanner = new Scanner(in).useDelimiter("\\W+");
        StringBuilder out = new StringBuilder();
        int prevEnd = 0;
        while(wordScanner.hasNext()) {
            String word = wordScanner.next();
            out.append(in.substring(prevEnd, wordScanner.match().start()));
            out.append(transform(word));
            prevEnd = wordScanner.match().end();
        }
        out.append(in.substring(prevEnd));
        return out.toString();
    }
}
