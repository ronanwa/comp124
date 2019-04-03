package edu.macalester.comp124.music;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestMedia {
    @Test
	public void testBasic() {
		Media m = new Media("/home/shilad/foo.mp3", "Giant Steps", 300);
		assertEquals(m.getFilePath(), "/home/shilad/foo.mp3");
		assertEquals(m.getName(), "Giant Steps");
		assertEquals(m.getCount(), 300);
        assertTrue(m.matchesQuery("giant"));
        assertTrue(m.matchesQuery("steps"));
        assertTrue(m.matchesQuery("Steps"));
	}

    @Test
	public void testTwoArgumentConstructor() {
		Media m = new Media("/home/shilad/foo.mp3", "Giant Steps");
		assertEquals(m.getFilePath(), "/home/shilad/foo.mp3");
		assertEquals(m.getName(), "Giant Steps");
		assertEquals(m.getCount(), 0);
	}

    @Test
    public void testToString() {
        Media media = new Media("/home/shilad/foo.mp3", "Giant Steps", 300);
        String string = media.toString();
		assertTrue(string.contains("foo.mp3"));
        assertTrue(string.contains("Giant Steps"));
    }

    @Test
	public void testEqualsMethod() {
		Media m1 = new Media("/home/shilad/foo.mp3", "Giant Steps", 0);
		Media m2 = new Media("/home/shilad/foo.mp3", "Giant Steps");
        Media m3 = new Media("/home/shilad/foo.mp3", "Giant Steps", 1);
        Media m4 = new Media("/home/shilad/foo.mp3", "Giant Stepz", 1);
		assertFalse(m1 == m2);
		assertTrue(m1.equals(m2));
        assertTrue(m1.equals(m3));
        assertFalse(m1.equals(m4));
	}
}
