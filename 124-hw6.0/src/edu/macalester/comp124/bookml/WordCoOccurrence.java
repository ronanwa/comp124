package edu.macalester.comp124.bookml;

import java.util.Map;

/**
 * Class WordCoOccurrence implements SimilarityMethod to override the computeSimilarity method (which calculates the similarity between two books
 */

public class WordCoOccurrence implements SimilarityMethod {

    /**
     * Calculates the similarity value between two books through the occurrence of similar words in both books
     * @param b1
     * @param b2
     * @return double similarity value
     */
    @Override
    public double computeSimilarity(Book b1, Book b2){
        double similarity=0;
        for(String word:b1.getWordCounts().keySet()){
            if(b2.getWordCounts().containsKey(word)){
                similarity++;
            }
        }
        return similarity;
    }
}
