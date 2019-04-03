package edu.macalester.comp124.stringtransformer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CapitalizerTest {

    private final StringTransformer capitalizeFirst = new Capitalizer();

    @Test
    public void handlesEmptyString() {
        assertEquals("", capitalizeFirst.transform(""));
    }

    @Test
    public void capitalizesFirst() {
        assertEquals("R", capitalizeFirst.transform("r"));
        assertEquals("Eureka!", capitalizeFirst.transform("eureka!"));
    }

}
