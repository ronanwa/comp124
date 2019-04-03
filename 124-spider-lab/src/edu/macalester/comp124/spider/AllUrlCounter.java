package edu.macalester.comp124.spider;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class AllUrlCounter {
	Map<String, Integer> urlMap;
	
	public AllUrlCounter() {
		urlMap = new HashMap<String, Integer>();
	}
	
	/**
	 * Increments the count a particular word.
	 * @param url The word to be counted.
	 */
	public void countUrl(String url) {
		Integer currentCount = urlMap.get(url);
		if (currentCount == null) {
			  // Java 1.5 'unboxing' and 'boxing' of an Integer
			currentCount = 0;
		}
        currentCount++;
        urlMap.put(url, currentCount);
	}
	
	/** 
	 * @return An array of all UrlCounter objects.  The array should
	 * have length equal to the number of UrlCounter objects.
	 */
	public UrlCount[] getCounts() {
		UrlCount trimmed[] = new UrlCount[urlMap.size()];
		// work here to get each key, val into a UrlCount object in this array
		int idx = 0;
		for (String key : urlMap.keySet()) {
			int nextVal = urlMap.get(key);
			UrlCount nextUrlCount = new UrlCount(key, nextVal);
			trimmed[idx] = nextUrlCount;
			idx++;
		}
		Arrays.sort(trimmed);
		return trimmed;
	}

}
