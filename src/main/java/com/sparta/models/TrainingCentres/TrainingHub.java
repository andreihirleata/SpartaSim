package com.sparta.models.TrainingCentres;

public class TrainingHub extends TrainingCenter {
    private final int max=100;

    @Override
    public boolean isFull() {
        return getTraineeList().size() >= max;
    }
}
