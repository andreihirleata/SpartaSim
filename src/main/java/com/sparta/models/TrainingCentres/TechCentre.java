package com.sparta.models.TrainingCentres;

public class TechCentre extends TrainingCenter {
    private final int max=200;
    private final String courseName;
    public TechCentre (String cName) {
        this.courseName = cName;
        this.maxMonths = 1;
    }

    public String getCourseName() {
        return courseName;
    }

    @Override
    public boolean isFull() {
        return getTraineeList().size() >= max;
    }

}