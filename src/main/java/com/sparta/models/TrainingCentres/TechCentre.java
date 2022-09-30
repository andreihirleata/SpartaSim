package com.sparta.models.TrainingCentres;

import java.time.LocalDate;
import java.util.Objects;

public class TechCentre extends TrainingCenter {
    private final int max=200;
    private final String courseName;
    public TechCentre (String cName) {
        this.courseName = cName;
    }

    public String getCourseName() {
        return courseName;
    }


    private int months = 0;
    private LocalDate startDate = LocalDate.now().plusMonths(months);
    private LocalDate endDate = startDate.plusMonths(3);


    public boolean closeCourse() {
        return startDate.isBefore(endDate) || startDate.equals(endDate);
    }

    public void closureCheck() {
        if(startDate.isBefore(endDate) && getTraineeList().size() < 25) {
            months++;
        } else {
            closeCourse();
        }
    }
    @Override
    public boolean isFull() {
        return getTraineeList().size() >= max;
    }

}