package com.example.bored_bard.dice_roller;

import java.util.Random;

// a die with a fixed number of sides
public class Die {
    private final Random rand = new Random();
    private final int numSides;

    public Die(int numSides) {
        this.numSides = numSides;
    }

    // rolls a random die and returns result
    public int roll() {
        // adding 1 expands the range to be inclusive of numSides
        return rand.nextInt(numSides) + 1;
    }

    public int getNumSides() {
        return this.numSides;
    }
}
