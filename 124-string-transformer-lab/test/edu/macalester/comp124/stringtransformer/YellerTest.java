package edu.macalester.comp124.stringtransformer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class YellerTest {
    
    private final StringTransformer capitalizer = new Yeller();
    
    @Test
    public void handlesEmptyString() {
        assertEquals("", capitalizer.transform(""));
    }
    
    @Test
    public void capitalizesAll() {
        assertEquals("A", capitalizer.transform("a"));
        assertEquals("ZONGLE", capitalizer.transform("zongle"));
    }
}
