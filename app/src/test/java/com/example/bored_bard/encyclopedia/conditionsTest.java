package com.example.bored_bard.encyclopedia;

import junit.framework.TestCase;

public class conditionsTest extends TestCase {
    conditions condition = new conditions();
    public void setUp() throws Exception {
        super.setUp();
        condition.setName("testName");
        condition.setIndex("test-name");
        condition.setUrl("/api/condition/blinded");
    }

    public void testGetIndex() {
        assertEquals("test-name",condition.getIndex());
    }

    public void testGetName() {
        assertEquals("testName",condition.getName());
    }

    public void testGetUrl() {
        assertEquals("/api/condition/blinded",condition.getUrl());
    }
}