package com.sparta.models.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomizerTest {

    @Test
    @DisplayName("generates random value between bounds")
    void getRandom() {
        int LBOUND = 20;
        int HBOUND = 500;
        int rand = Randomizer.getRandom(LBOUND,HBOUND);
        Assertions.assertTrue(rand > LBOUND && rand < HBOUND);

    }

    @Test
    @DisplayName("returns a valid course value")
    void generateRandomCourse() {
        String course = Randomizer.generateRandomCourse();
        Assertions.assertTrue(course.equals("Java Course")
                                    || course.equals("C# Course")
                                    || course.equals("Data course")
                                    || course.equals("Devops course")
                                    || course.equals("Business course"));
    }
}