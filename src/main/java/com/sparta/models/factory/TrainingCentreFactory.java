package com.sparta.models.factory;

import com.sparta.models.TrainingCentres.Bootcamp;
import com.sparta.models.TrainingCentres.TechCentre;
import com.sparta.models.TrainingCentres.TrainingCenter;
import com.sparta.models.TrainingCentres.TrainingHub;
import com.sparta.models.util.Randomizer;

public class TrainingCentreFactory {
    public static TrainingCenter generateTrainingCentre() {
        return switch (Randomizer.getRandom(0, 2)) {
            case 0 -> new TechCentre(Randomizer.generateRandomCourse());
            case 1 -> new Bootcamp();
            case 2 -> new TrainingHub();
            default -> throw new IllegalStateException("Unexpected value: " + Randomizer.getRandom(0, 2));
        };
    }
}
