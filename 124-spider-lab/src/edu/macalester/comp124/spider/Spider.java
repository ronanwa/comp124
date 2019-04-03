package edu.macalester.comp124.spider;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Downloads web page content starting with a starting url.
 * If the spider encounters links in the content, it downloads
 * those as well.
 * 
 * Steps:
 * 1. Complete the processPage method.  One TestSpider unit tests should pass.
 * 2. Complete the crawl() method.  Both TestSpider unit tests should pass.
 *  
 * @author shilad
 *
 */
public class Spider {
	/**
	 * Urls waiting to be scraped.  The "work" left to do.
	 */
	private Queue<String> work = new LinkedList<String>();
	
	/**
	 * Keeps track of counts for each url.
	 */
	private AllUrlCounter urlCounter = new AllUrlCounter();
	
	/**
	 * Maximum number of urls that should be scraped.
	 */
	private int maxUrls;
	
	/**
	 * URLs that have already been retrieved.
	 */
	private List<String> finished = new ArrayList<String>();
	
	/**
	 * Helps download and parse the web pages.
	 */
	private HttpHelper helper = new HttpHelper();
	
	/**
	 * Creates a new spider that will crawl at most maxUrls.
	 * @param maxUrls
	 */
	public Spider(int maxUrls) {
		this.maxUrls = maxUrls;
	}
	
	/**
	 * Crawls at most maxUrls starting with beginningUrl.
	 * @param beginningUrl
	 */
	public void crawl(String beginningUrl) {
        work.add(beginningUrl);
		while(finished.size()<maxUrls){
			String url=work.remove();
			processPage(url);
			finished.add(url);
		}
	}
	
	/**
	 * Retrieves content from a url and processes that content.
     *
	 * @param url   theURL for the web page
	 */
	public void processPage(String url) {
		List<String> links=helper.extractLinks(url);
		for(String link : links){
			urlCounter.countUrl(link);
			if(!finished.contains(link) && !work.contains(link)){
				work.add(link);
			}
		}
		// For each link increment the
		// count for the link and queue up the link for future scraping if it has not already been finished.
		// HINT: Take a look at the helper class
	}
	
	/**
	 * Returns the number of times the spider encountered
	 * links to each url.  The url are returned in increasing
	 * frequency order.
	 * 
	 * @return
	 */
	public UrlCount[] getUrlCounts() {
		return urlCounter.getCounts();
	}
	
	/**
	 * These getters should only be used for testing.
	 */
	Queue<String> getWork() { return work; }
	List<String> getFinished() { return finished; }
}
