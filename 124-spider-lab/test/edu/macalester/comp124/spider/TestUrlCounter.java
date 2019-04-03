package edu.macalester.comp124.spider;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestUrlCounter {

    /**
     * Test the getDifference method of the RunSpider.
     */
    @Test
    public void testGetDifference() {

        UrlCount url0 = new UrlCount("foo", 4);
        UrlCount url1 = new UrlCount("bar", 2);
        UrlCount url2 = new UrlCount("baa", 25);
        UrlCount url3 = new UrlCount("moose", 25);

        UrlCount[] urlCounts1 = {url0, url2};
        UrlCount[] urlCounts2 = {url0, url1, url2, url3};

        List<UrlCount> difference = RunSpider.getDifference(urlCounts1, urlCounts2);
        assertEquals(2, difference.size());
        assertTrue(difference.contains(url1));
        assertTrue(difference.contains(url3));
        assertFalse(difference.contains(url0));
        assertFalse(difference.contains(url2));
    }
}


