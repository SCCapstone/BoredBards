package com.example.bored_bard.encyclopedia;

import junit.framework.TestCase;

public class classesTest extends TestCase {
    classes c = new classes();
    public void setUp() throws Exception {
        super.setUp();
        c.setName("testName");
        c.setIndex("test-name");
        c.setHit_die(24);
    }

    public void testTestGetName() {
        assertEquals("testName",c.getName());
    }

    public void testGetHit_die() {
        assertEquals(24,c.getHit_die());
    }

    public void testGetIndex() {
        assertEquals("test-name",c.getIndex());
    }
}