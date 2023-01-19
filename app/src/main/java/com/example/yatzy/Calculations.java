package com.example.yatzy;

import java.util.Random;

public class Calculations {

    // function to generate a random number from 1 to 6
    public static int getRandomNumberForDice() {
        final int min = 1;
        final int max = 6;
        final int random = new Random().nextInt((max - min) + 1) + min;
        return random;
    }
}
