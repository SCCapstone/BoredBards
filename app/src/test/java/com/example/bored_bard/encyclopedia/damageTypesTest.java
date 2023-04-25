package com.example.bored_bard.encyclopedia;

import junit.framework.TestCase;

public class damageTypesTest extends TestCase {

    damageTypes dmg = new damageTypes();
    public void setUp() throws Exception {
        super.setUp();
        dmg.setName("testName");
        dmg.setIndex("test-name");
        dmg.setUrl("/api/damage-type/piercing");
    }

    public void testGetIndex() {
        assertEquals("test-name",dmg.getIndex());
    }

    public void testGetName() {
        assertEquals("testName",dmg.getName());
    }

    public void testGetUrl() {
        assertEquals("/api/damage-type/piercing",dmg.getUrl());
    }
}