package com.example.bored_bard.dice_roller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DieTest {
    Die d4_test = new Die(4);
    Die d6_test = new Die(6);
    Die d8_test = new Die(8);
    Die d10_test = new Die(10);
    Die d12_test = new Die(12);
    Die d20_test = new Die(20);

    @Test
    public void roll() {
        // tests that none return 0, 10 times each
        for (int i = 0; i < 10; i++) {
            assertTrue(d4_test.roll() != 0);
            assertTrue(d6_test.roll() != 0);
            assertTrue(d8_test.roll() != 0);
            assertTrue(d10_test.roll() != 0);
            assertTrue(d12_test.roll() != 0);
            assertTrue(d20_test.roll() != 0);
        }
    }
}