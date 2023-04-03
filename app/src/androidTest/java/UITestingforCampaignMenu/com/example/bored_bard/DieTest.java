package UITestingforCampaignMenu.com.example.bored_bard;

import static org.junit.Assert.*;

import com.example.bored_bard.dice_roller.Die;
import com.example.bored_bard.dice_roller.DieRoller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kotlin.Triple;

public class DieTest {
    Die d4_test = new Die(4);
    Die d6_test = new Die(6);
    Die d8_test = new Die(8);
    Die d10_test = new Die(10);
    Die d12_test = new Die(12);
    Die d20_test = new Die(20);

    DieRoller roller = new DieRoller();

    @Test
    public void roll() {
        // tests that none return 0, 10 times each
        for (int i = 0; i < 10; i++) {
            assertTrue(d4_test.roll() != 0);
            assertTrue(d4_test.roll() <= d4_test.getNumSides());
            assertTrue(d6_test.roll() != 0);
            assertTrue(d6_test.roll() <= d6_test.getNumSides());
            assertTrue(d8_test.roll() != 0);
            assertTrue(d8_test.roll() <= d8_test.getNumSides());
            assertTrue(d10_test.roll() != 0);
            assertTrue(d10_test.roll() <= d10_test.getNumSides());
            assertTrue(d12_test.roll() != 0);
            assertTrue(d12_test.roll() <= d12_test.getNumSides());
            assertTrue(d20_test.roll() != 0);
            assertTrue(d20_test.roll() <= d20_test.getNumSides());
        }
    }

    @Test
    public void checkAdv() {
        Triple<String, Integer, Integer> testRes = roller.advantagedRoll();
        assertTrue(Integer.parseInt(testRes.getFirst()) != 0);
        assertEquals(Integer.parseInt(testRes.getFirst()), Math.max(testRes.getSecond(), testRes.getThird()));
    }

    @Test
    public void checkDisadv() {
        Triple<String, Integer, Integer> testRes = roller.disadvantagedRoll();
        assertTrue(Integer.parseInt(testRes.getFirst()) != 0);
        assertEquals(Integer.parseInt(testRes.getFirst()), Math.min(testRes.getSecond(), testRes.getThird()));
    }

}