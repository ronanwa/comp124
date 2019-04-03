package edu.macalester.comp124.spider;

import java.util.Objects;

/**
 * Counts the number of times a url has occurred.
 * @author shilad
 */
public class UrlCount implements Comparable<UrlCount>{
	private int count;
	private String url;
	
	/**
	 * @param url
	 */
	public UrlCount(String url, int count) {
		this.count = count;
		this.url = url.toLowerCase();
	}	
	
	/**
	 * @return the numOccurences
	 */
	public int getCount() {
		return count;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	
	/**
	 * Increments the internal counter for the number of occurences;
	 */
	public void increment() {
		count++;
	}

	public int compareTo(UrlCount o) {
		if (count != o.getCount()) {
			return count - o.count;
		} else {
			return url.compareTo(o.url);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		UrlCount urlCount = (UrlCount) o;
		return url.equals(urlCount.url);
	}

	@Override
	public int hashCode() {
		return Objects.hash(url);
	}
}
