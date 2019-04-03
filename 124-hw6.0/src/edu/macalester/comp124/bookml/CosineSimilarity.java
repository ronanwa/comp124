package edu.macalester.comp124.bookml;


public class CosineSimilarity implements SimilarityMethod{

    /**
     * Cosine similarity calculation between two books
     * @param b1
     * @param b2
     * @return cosine similarity value
     */
    @Override
    public double computeSimilarity(Book b1, Book b2){
        double S1=0;
        double S2=0;
        double S3=0;

        for(String word : b1.getWordCounts().keySet()){
            if(b2.getWordCounts().keySet().contains(word)){
                S1+=b1.getWordCounts().get(word)*b2.getWordCounts().get(word);
            }
        }

        for(String word : b1.getWordCounts().keySet()){
            S2+=Math.pow(b1.getWordCounts().get(word),2);
        }

        for(String word : b2.getWordCounts().keySet()){
            S3+=Math.pow(b2.getWordCounts().get(word),2);
        }

        return S1/(Math.sqrt(S2)*Math.sqrt(S3));
    }
}
