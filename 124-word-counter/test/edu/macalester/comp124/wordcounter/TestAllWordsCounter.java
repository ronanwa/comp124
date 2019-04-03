package edu.macalester.comp124.wordcounter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * @author Shilad Sen
 */
public class TestAllWordsCounter {

    @Test
    public void testInitial() {
        AllWordsCounter counter = new AllWordsCounter();
        assertEquals(0, counter.getCount("foo"));
        assertEquals(0, counter.getCount("bar"));
        assertEquals(0, counter.getCount("baz"));
        assertEquals(0, counter.getNumWords());
    }

    @Test
    public void testIncrement() {
        AllWordsCounter counter = new AllWordsCounter();
        assertEquals(0, counter.getCount("foo"));
        counter.incrementCountForWord("foo");
        assertEquals(1, counter.getCount("foo"));
        counter.incrementCountForWord("foo");
        counter.incrementCountForWord("foo");
        counter.incrementCountForWord("bar");
        counter.incrementCountForWord("bar");
        assertEquals(3, counter.getCount("foo"));
        assertEquals(2, counter.getCount("bar"));
        assertEquals(2, counter.getNumWords());
    }

    @Test
    public void testCaseInsensitive() {
        AllWordsCounter counter = new AllWordsCounter();
        assertEquals(0, counter.getCount("foo"));
        counter.incrementCountForWord("foO");
        counter.incrementCountForWord("fOo");
        counter.incrementCountForWord("fo-o");
        counter.incrementCountForWord("bar");
        counter.incrementCountForWord("bar!");
        assertEquals(3, counter.getCount("foo"));
        assertEquals(2, counter.getCount("bar"));
        assertEquals(2, counter.getNumWords());
    }



    @Test
    public void testGetAllWords() {
        AllWordsCounter counter = new AllWordsCounter();
        assertEquals(0, counter.getCount("foo"));
        counter.incrementCountForWord("foo");
        counter.incrementCountForWord("fOo");
        counter.incrementCountForWord("fo-o");
        counter.incrementCountForWord("bar");
        counter.incrementCountForWord("bar!");
        assertEquals(3, counter.getCount("foo"));
        assertEquals(2, counter.getCount("bar"));
        assertEquals(2, counter.getNumWords());
        assertEquals(counter.getAllWords(), new String[] { "foo", "bar"});
    }

}
