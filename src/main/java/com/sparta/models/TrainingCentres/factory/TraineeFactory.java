package com.sparta.models.TrainingCentres.factory;

import com.sparta.Trainee;
import com.sparta.models.util.Randomizer;

public class TraineeFactory {
    public static Trainee generateTrainee() {
       return new Trainee(Randomizer.generateRandomCourse());
    }
}
