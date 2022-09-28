package com.sparta.models.TrainingCentres;

public class Bootcamp extends TrainingCenter {
    private final int max=500;


    @Override
    public boolean isFull() {
        return getTraineeList().size() >= max;
    }
}
