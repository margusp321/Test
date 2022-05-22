package com.LHV.nameMatching;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class nameMatchTest extends TestCase {
    @BeforeEach
    public void setUp(){
        var nameMatch = new nameMatch();
    }


    @Test
    public void testLevenshteinDistance100 () {
        assertEquals(100, nameMatch.LevenshteinDistance("Osama bin Laden", "Osama bin Laden"));
    }
    @Test
    public void testLevenshteinDistance80 () {
        assertEquals(80, nameMatch.LevenshteinDistance("Osama bin Laden", "Lsama bin Laden"));
    }
    @Test
    public void testLevenshteinDistance60 () {
        assertEquals(60, nameMatch.LevenshteinDistance("Osama bin Laden", "Lfeea bin Laden"));
    }
    @Test
    public void testLevenshteinDistance20 () {
        assertEquals(20, nameMatch.LevenshteinDistance("Osama bin Laden", "Osam9 ooo deggb"));
    }
    @Test
    public void testLevenshteinDistance10 () {
        assertEquals(10, nameMatch.LevenshteinDistance("Osama bin Laden", "Osinu ooo deggb"));
    }
    @Test
    public void testLevenshteinDistance0 () {
        assertEquals(0, nameMatch.LevenshteinDistance("Osama bin Laden", "jgjhgkjjjjjjjjjjjjjjj"));
    }
    @Test
    public void testremoveNoise () {
        assertEquals("osama bin laden", nameMatch.removeNoise("to the Osama bin Laden"));
    }
    @Test
    public void testremoveNoise2 () {
        assertEquals("kuri koer", nameMatch.removeNoise("Kuri Koer"));
    }
    @Test
    public void testpartialMatch () {
        assertEquals(66, nameMatch.partialMatch("osama bin laden", "osama laden"));
    }
    @Test
    public void testpartialMatch2 () {
        assertEquals(66, nameMatch.partialMatch("osama laden", "osama bin laden"));
    }
    @Test
    public void testpartialMatch3 () {
        assertEquals(100, nameMatch.partialMatch("osama-bin laden ", "osama bin laden"));
    }
    @Test
    public void testpartialMatch4 () {
        assertEquals(66, nameMatch.partialMatch("osama bin laden ", "osama laden"));
    }
}