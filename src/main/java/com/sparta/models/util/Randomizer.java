package com.sparta.models.util;

import java.util.Random;

public class Randomizer {

    public static int getRandom(int lowLimit, int highLimit) {
        Random rand = new Random();
        return rand.nextInt(lowLimit,highLimit);
    }
}
