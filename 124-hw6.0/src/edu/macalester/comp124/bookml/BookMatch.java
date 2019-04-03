package edu.macalester.comp124.bookml;


public class BookMatch implements Comparable<BookMatch>{
    private Book book;
    private double similarityScore;

    public BookMatch(Book book, double similarityScore){
        this.book=book;
        this.similarityScore=similarityScore;
    }

    public Book getBook(){
        return book;
    }

    public double getSimilarityScore(){
        return similarityScore;
    }

    @Override
    public int compareTo(BookMatch other){
        if(similarityScore<other.getSimilarityScore()){
            return -1;
        }else if(similarityScore>other.getSimilarityScore()){
            return 1;
        } else {
            return 0;
        }
    }
}
