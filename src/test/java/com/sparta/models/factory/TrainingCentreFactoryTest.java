package com.sparta.models.factory;

import com.sparta.Academy;
import com.sparta.models.TrainingCentres.factory.TrainingCentreFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TrainingCentreFactoryTest {

    @Test
    @DisplayName("adds new training centre to list")
    void generateTrainingCentre() {
        int initialSize = Academy.centerList.size();
        TrainingCentreFactory.generateTrainingCentre();
        Assertions.assertTrue(Academy.centerList.size() > initialSize);
    }
}