package edu.macalester.comp124.spider;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author shilad
 *
 */
public class TestSpider  {
	private static final String BEGINNING_URL = "https://www.macalester.edu";
	/**
	 * Test the processPage method of the spider.
	 */
    @Test
	public void testProcessPage() {
		Spider spider = new Spider(10);
		spider.processPage(BEGINNING_URL);
		
		assertTrue(spider.getWork().size() > 6);
		
		int i = 0;
		for (UrlCount urlCount : spider.getUrlCounts()) {
			i += urlCount.getCount();
		}
		assertTrue(i >= 10);
	}

    @Test
	public void testCrawl() {
        Spider spider = new Spider(2);
		spider.crawl(BEGINNING_URL);
		
		assertEquals(2, spider.getFinished().size());
		assertTrue(spider.getFinished().contains(BEGINNING_URL));
		assertTrue(spider.getWork().size() > 10);

		int i = 0;
		for (UrlCount urlCount : spider.getUrlCounts()) {
			i += urlCount.getCount();
		}
		assertTrue(i >= 10);
	}
	
	

}
