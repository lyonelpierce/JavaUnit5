package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MissingNumberTest {

    private int[] missingMax = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    private int[] missingNone = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    private int[] missingSeven = { 1, 2, 3, 4, 5, 6, 8, 9, 10 };
    private MissingNumber mn = new MissingNumber();

    @Test
    void testFindMissingNumber() {
        assertEquals(10, mn.findMissingNumber(missingMax, 10));
    }

    @Test
    void testFindMissingNumber1() {
        assertEquals(0, mn.findMissingNumber(missingNone, 10));
    }

    @Test
    void testFindMissingNumber2() {
        assertEquals(7, mn.findMissingNumber(missingSeven, 10));
    }
}