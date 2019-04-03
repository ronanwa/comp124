package edu.macalester.comp124.spider;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class TestHttpHelper {
	private static final String HTML_TITLE = "<title>Macalester College: Private Liberal Arts College</title>";

    @Test
	public void testRetrieve() {
		HttpHelper helper = new HttpHelper();
		String html = helper.retrieve("https://www.macalester.edu");
		assertTrue(html.indexOf(HTML_TITLE) >= 0);
	}


    @Test
	public void testExtractLinks() {
		String html = "<html><body>\n" + 
				"<a href=\"https://www.hjsoft.com/\">John</a>\n" +
				"<a href=\"https://www.google.com/\">Google</a>\n" +
				"<a href = \"https://www.stackoverflow.com/\">StackOverflow</a>\n" +
				"<a href = \"bar/1.html\">StackOverflow</a>\n" + 
				"</body></html>";
		HttpHelper helper = new HttpHelper();
		List<String> links = helper.extractLinks("http://foo.com", html);
		assertEquals(4, links.size());
		assertEquals("https://www.hjsoft.com/", links.get(0));
		assertEquals("https://www.google.com/", links.get(1));
		assertEquals("https://www.stackoverflow.com/", links.get(2));
		assertEquals("http://foo.com/bar/1.html", links.get(3));
	}
}
