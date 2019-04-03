package edu.macalester.comp124.bookml;

import java.util.*;

/**
 * A class to guess authors of a book.
 *
 * The intended use of this object is that it would be instantiated once, but used
 * many times.
 *
 */
public class  AuthorGuesser {
    // an array containing the file name of all the provided books with known
    // authors. This array will help you load in all the books for future
    // reference.
    private static final String[] BOOK_FILES = {"74-0.txt",
            "76-0.txt",
            "86-0.txt",
            "119-0.txt",
            "121-0.txt",
            "158-0.txt",
            "245-0.txt",
            "294-0.txt",
            "1212-0.txt",
            "1644-0.txt",
            "1837-0.txt",
            "2895-0.txt",
            "3171-0.txt",
            "3174-0.txt",
            "3176-0.txt",
            "3177.txt",
            "3178-0.txt",
            "3179-0.txt",
            "3180-0.txt",
            "4295-0.txt",
            "5260-0.txt",
            "pg105.txt",
            "pg126.txt",
            "pg355.txt",
            "pg423.txt",
            "pg946.txt",
            "pg1213.txt",
            "pg1638.txt",
            "pg1661.txt",
            "pg2097.txt",
            "pg2343.txt",
            "pg2344.txt",
            "pg2345.txt",
            "pg2346.txt",
            "pg2347.txt",
            "pg2348.txt",
            "pg2349.txt",
            "pg42671.txt",
            "pg19484.txt",
            "pg21839.txt"};


    // parameter to the guessing algorithm.
    private int k;
    // similarity method to use as part of guessing algorithm.
    private SimilarityMethod similarity;
    // list of processed book objects
    private List<Book> processedBooks;


    public AuthorGuesser(int k, SimilarityMethod similarty) {
        this.k=k;
        this.similarity=similarty;
        this.processedBooks=convertBooks(BOOK_FILES);
    }

    /**
     * Given a book whose author is unknown, or assumed to be wrong, guess the
     * correct author using the k-nearest-neighbors algorithm.
     *
     * This method should be programed in a way that it can be called more than
     * once, with different books, without creating a new AuthorGuesser each time.
     *
     * @param unknownAuthorBook - the book object describing the book with unknown
     *                          author
     * @return - the name of the algorithm's best guess for the true author of the
     * unknown author book.
     */
    public String guessAuthor(Book unknownAuthorBook) {
        PriorityQueue<BookMatch> kSimilarBooks=findSimilarBooks(processedBooks, unknownAuthorBook);
        List<Book> finalAuthors=convertHeapToList(kSimilarBooks);
        return mostCommonAuthor(finalAuthors);
    }

    /**
     * Takes the file names of each eBook and converts each one into its own Book object
     * @param bookFiles
     * @return list of book objects
     */
    public List convertBooks(String[] bookFiles){
        List<Book> processedBooks=new ArrayList<>();
        for(String fileName:bookFiles){
            Book book=new Book(fileName);
            processedBooks.add(book);
        }
        return processedBooks;
    }

    /**
     * Takes all of the known books and places them into a min heap/priority queue
     * @param processedBooks
     * @param unknownAuthorBook
     * @return min heap of most similar books
     */
    protected PriorityQueue<BookMatch> findSimilarBooks(List<Book> processedBooks, Book unknownAuthorBook){
        PriorityQueue<BookMatch> minHeap=new PriorityQueue<>();
        for(Book labeledBook: processedBooks){
            double similarityScore=similarity.computeSimilarity(labeledBook, unknownAuthorBook);
            BookMatch match=new BookMatch(labeledBook, similarityScore);
            if(minHeap.size()<k){
                minHeap.add(match);
            }else if(minHeap.size()>0 && minHeap.size()==k){
                BookMatch lowestScore=minHeap.peek();
                if(lowestScore.getSimilarityScore()<similarityScore){
                    minHeap.remove(lowestScore);
                    minHeap.add(match);
                }
            }
        }
        return minHeap;
    }

    /**
     * Converts the min heap to a list of final most similar books
     * @param kSimilarBooks
     * @return list of most similar book with known authors
     */
    protected List<Book> convertHeapToList(PriorityQueue<BookMatch> kSimilarBooks){
        List<Book> finalAuthors=new ArrayList<>();
        for(BookMatch book: kSimilarBooks){
            finalAuthors.add(book.getBook());
        }
        return finalAuthors;
    }

    /**
     * Given a list of book return the author that appears the most
     * @param books - a list of books
     * @return the most common author in books
     */
    public String mostCommonAuthor(List<Book> books) {
        Map<String, Integer> countAuthors = new HashMap<>();
        for(Book b: books) {
            if(countAuthors.containsKey(b.getAuthor())) {
                countAuthors.put(b.getAuthor(), 1+countAuthors.get(b.getAuthor()));
            } else {
                countAuthors.put(b.getAuthor(), 1);
            }
        }
        int authorMax = -1;
        String maxAuthor = null;

        //NOTE - this is a good example of how to iterate over the keys of a map.
        for(String author: countAuthors.keySet()) {
            int count = countAuthors.get(author);
            if(count > authorMax) {
                maxAuthor = author;
                authorMax = count;
            }
        }
        return maxAuthor;
    }

    /**
     * Main Function
     * @param args
     */
    public static void main(String[] args){
        Book anonAuthor=new Book("anon.txt");

        AuthorGuesser agCosineSimilarity=new AuthorGuesser(7, new CosineSimilarity());
        AuthorGuesser agWordsCoOccurrence=new AuthorGuesser(5, new WordCoOccurrence());

        System.out.println(agCosineSimilarity.guessAuthor(anonAuthor));
        System.out.println(agWordsCoOccurrence.guessAuthor(anonAuthor));

    }

}