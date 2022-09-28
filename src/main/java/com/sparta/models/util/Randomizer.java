//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.sparta.models.util;

import java.util.Random;

public class Randomizer {
    public Randomizer() {
    }

    public static int getRandom(int lowLimit, int highLimit) {
        Random rand = new Random();
        return rand.nextInt(lowLimit, highLimit + 1);
    }

    public static String generateRandomCourse() {
        return switch (Randomizer.getRandom(0, 4)) {
            case 0 -> Courses.JAVA.getCourseName();
            case 1 -> Courses.C_SHARP.getCourseName();
            case 2 -> Courses.DATA.getCourseName();
            case 3 -> Courses.DEVOPS.getCourseName();
            case 4 -> Courses.BUSINESS.getCourseName();
            default -> throw new IllegalStateException("Unexpected value: " + Randomizer.getRandom(0, 4));
        };
    }
}
