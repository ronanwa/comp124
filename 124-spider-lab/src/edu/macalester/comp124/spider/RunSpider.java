package edu.macalester.comp124.spider;


import java.util.ArrayList;
import java.util.List;

/**
 * Downloads web pages by following http links located
 * in the html of BEGINNING_URL.  Recursively repeats
 * the process.
 * 
 * @author shilad
 *
 */
public class RunSpider {
	private static final String BEGINNING_URL = "https://www.macalester.edu";

	/**
	 * Run the spider program.
	 * @param args
	 */
	public static void main(String [] args) {
		Spider spider = new Spider(10);
		spider.crawl(BEGINNING_URL);
		printURLCounts(spider.getUrlCounts());
	}

	public static void printURLCounts(UrlCount[] counts){
		for (UrlCount urlCount : counts) {
			System.out.println("url " + urlCount.getUrl() + " is " + urlCount.getCount());
		}
	}

	public static List<UrlCount> getDifference(UrlCount[] set, UrlCount[] set2){
		List<UrlCount> list=new ArrayList<UrlCount>();
		for(int i=set2.length-1; i>0; i--){
			UrlCount value=set2[i];
			int counter=0;
			for(int j=set.length-1; j>0; j--) {
				if(value.equals(set[j])){
					counter++;
				}
			}
			if(counter==0){
				list.add(value);
			}
		}
		return list;
	}
}
