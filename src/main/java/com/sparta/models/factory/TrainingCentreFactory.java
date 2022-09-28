package com.sparta.models.factory;

import com.sparta.Academy;
import com.sparta.models.TrainingCentres.Bootcamp;
import com.sparta.models.TrainingCentres.TechCentre;
import com.sparta.models.TrainingCentres.TrainingHub;
import com.sparta.models.util.Randomizer;

public class TrainingCentreFactory {
    public static void generateTrainingCentre() {
        switch (Randomizer.getRandom(0, 2)) {
            case 0: {
                Academy.centerList.add(new TechCentre(Randomizer.generateRandomCourse()));
            }
            case 1: {
                if(Academy.centerList.stream().filter(t -> t.getClass() == Bootcamp.class).count() < 2) {
                    Academy.centerList.add(new Bootcamp());
                } else generateTrainingCentre();
            }
            case 2:  {
                int rand = Randomizer.getRandom(1,3);
                for (int i = 0; i < rand; i++) {
                    Academy.centerList.add(new TrainingHub());
                }
            }
        }
    }

}
