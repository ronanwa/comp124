package edu.macalester.comp124.spider;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HttpHelper {
	
	/**
	 * Returns the contents of a url as a string.
	 * @param urlStr
	 * @return String contents or null in case of an error.
	 */
	public String retrieve(String urlStr) {
        try {
            Document htmlDoc = Jsoup.connect(urlStr).get();
            return htmlDoc.toString();

        } catch (Exception ex) {
            System.err.println("http fetch of '" + urlStr + "' failed: "+ex.getMessage());
            //ex.printStackTrace();
            return null;
        }
	}

	/**
	 * Returns the web links contained in the website with baseURL.
	 * @param baseUrl
	 * @return
	 */
	public List<String> extractLinks(String baseUrl) {
        try {
            Document htmlDoc = Jsoup.connect(baseUrl).get();
            return extractLinks(htmlDoc);

        } catch (Exception ex) {
            System.err.println("http fetch of '" + baseUrl + "' failed: "+ex.getMessage());
            //ex.printStackTrace();
            return new ArrayList<>();
        }
	}

    /**
     * Returns the web links contained in the html content
     * @param baseUrl
     * @param html
     * @return
     */
	public List<String> extractLinks(String baseUrl, String html){
	    Document htmlDoc = Jsoup.parse(html);
	    htmlDoc.setBaseUri(baseUrl);
	    return extractLinks(htmlDoc);
    }

    private List<String> extractLinks(Document htmlDoc){
        List<String> links = new ArrayList<>();
        Elements elements = htmlDoc.select("a[href]");
        for(Element elem : elements){
            links.add(elem.attr("abs:href"));
        }

        return links;
    }


}
