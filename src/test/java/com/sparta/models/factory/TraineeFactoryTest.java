package com.sparta.models.factory;

import com.sparta.Trainee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TraineeFactoryTest {
    @Test
    @DisplayName("generates a new Trainee")
    void traineeFactoryTest() {
      Trainee t = TraineeFactory.generateTrainee();
        Assertions.assertTrue(t instanceof Trainee);
    }

}