package com.ranella;

import static org.junit.Assert.*;

public class UtilitiesTest {

    private Utilities utilities = new Utilities();

    @org.junit.Test
    public void everyNthChar() throws Exception {

       assertArrayEquals("el".toCharArray(),utilities.everyNthChar("hello".toCharArray(), 2));
        assertArrayEquals("hello".toCharArray(),utilities.everyNthChar("hello".toCharArray(), 6));
    }

    @org.junit.Test
    public void removePairs() throws Exception {
        String source1 = "AABCDDEFF";
        String result1 = utilities.removePairs(source1);
        assertEquals("ABCDEF", result1);

        String source2 = "ABCCABDEEF";
        String result2 = utilities.removePairs(source2);
        assertEquals("ABCABDEF",result2);
    }

    @org.junit.Test
    public void converter() throws Exception {
        assertEquals(300, utilities.converter(10,5));
    }

    @org.junit.Test (expected = ArithmeticException.class)
    public void converterException() throws Exception {
        utilities.converter(10,0);
    }

    @org.junit.Test
    public void nullIfOddLength() throws Exception {
        assertNotNull(utilities.nullIfOddLength("even"));
        assertNull(utilities.nullIfOddLength("odd"));
    }

}