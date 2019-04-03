package edu.macalester.comp124.stringtransformer;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class IdentityTransformerTest {
    
    private final StringTransformer ident = new IdentityTransformer();
    
    @Test
    public void handlesEmptyString() {
        assertEquals("", ident.transform(""));
    }
    
    @Test
    public void leavesEverythingAlone() {
        assertEquals("a", ident.transform("a"));
        assertEquals("zonGle", ident.transform("zonGle"));
    }
}
