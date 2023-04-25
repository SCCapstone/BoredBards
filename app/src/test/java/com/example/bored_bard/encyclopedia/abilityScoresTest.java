package com.example.bored_bard.encyclopedia;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;

public class abilityScoresTest extends TestCase {
    abilityScores ability = new abilityScores();

    @Override
    public void setUp() throws Exception {
        super.setUp();
        ability.setName("testName");
        ability.setIndex("test-name");
        ability.setFull_name("testFullName");
        ability.setUrl("/api/ability-scores/cha");
    }

    public void testGetDesc() {

    }

    public void testGetFull_name() {

        assertEquals("testFullName",ability.getFull_name());
    }

    public void testGetIndex() {
        assertEquals("test-name",ability.getIndex());
    }

    public void testGetName() {
        assertEquals("testName",ability.getName());
    }

    public void testSkillsToString() {

    }

    public void testGetUrl() {
        assertEquals("/api/ability-scores/cha",ability.getUrl());
    }
}
