package com.example.bored_bard.encyclopedia;

import junit.framework.TestCase;

public class alignmentTest extends TestCase {
    alignment align = new alignment();

    public void setUp() throws Exception {
        super.setUp();
        align.setName("testName");
        align.setIndex("test-name");
        align.setUrl("/api/alignment/chaotic-neutral");
    }

    public void testGetDesc() {
    }

    public void testGetIndex() {
        assertEquals("test-name",align.getIndex());
    }

    public void testGetName() {
        assertEquals("testName",align.getName());
    }

    public void testGetUrl() {
        assertEquals("/api/alignment/chaotic-neutral",align.getUrl());
    }
}