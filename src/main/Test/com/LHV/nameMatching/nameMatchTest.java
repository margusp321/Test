package com.LHV.nameMatching;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static com.LHV.nameMatching.nameMatch.removeNoise;

public class nameMatchTest {
    @Before
    @BeforeEach
    public void setUp(){
        var nameMatch = new nameMatch();
    }


    @Test
    public void testLevenshteinDistance100 () {
        Assert.assertEquals(100, nameMatch.LevenshteinDistance("Osama bin Laden", "Osama bin Laden"));
    }
    @Test
    public void testLevenshteinDistance80 () {
        Assert.assertEquals(80, nameMatch.LevenshteinDistance("Osama bin Laden", "Lsama bin Laden"));
    }
    @Test
    public void testLevenshteinDistance60 () {
        Assert.assertEquals(60, nameMatch.LevenshteinDistance("Osama bin Laden", "Lfeea bin Laden"));
    }
    @Test
    public void testLevenshteinDistance20 () {
        Assert.assertEquals(20, nameMatch.LevenshteinDistance("Osama bin Laden", "Osam9 ooo deggb"));
    }
    @Test
    public void testLevenshteinDistance10 () {
        Assert.assertEquals(10, nameMatch.LevenshteinDistance("Osama bin Laden", "Osinu ooo deggb"));
    }
    @Test
    public void testLevenshteinDistance0 () {
        Assert.assertEquals(0, nameMatch.LevenshteinDistance("Osama bin Laden", "jgjhgkjjjjjjjjjjjjjjj"));
    }
    @Test
    public void testremoveNoise () {
        Assert.assertEquals("tanel tamm", removeNoise("Dr. Tanel Tamm"));
    }

    @Test
    public void testpartialMatch () {
        Assert.assertEquals(66, nameMatch.partialMatch("osama bin laden", "osama laden"));
    }
    @Test
    public void testpartialMatch2 () {
        Assert.assertEquals(66, nameMatch.partialMatch("osama laden", "osama bin laden"));
    }
    @Test
    public void testpartialMatch3 () {
        Assert.assertEquals(100, nameMatch.partialMatch("osama-bin laden ", "osama bin laden"));
    }
    @Test
    public void testpartialMatch4 () {
        Assert.assertEquals(66, nameMatch.partialMatch("osama bin laden ", "osama laden"));
    }
}