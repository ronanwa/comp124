package edu.macalester.comp124.stringtransformer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PigLatinTest {

    private final StringTransformer pigLatinizer = new PigLatinizer();

    @Test
    public void handlesEmptyString() {
        assertEquals("", pigLatinizer.transform(""));
    }

    @Test
    public void pigLatinTranslator() {
        assertEquals("ryay", pigLatinizer.transform("r"));
        assertEquals("eurekayay", pigLatinizer.transform("eureka"));
        assertEquals("iglatinpay", pigLatinizer.transform("piglatin"));
    }
}