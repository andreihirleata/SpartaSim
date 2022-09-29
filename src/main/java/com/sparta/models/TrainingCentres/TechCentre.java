package com.sparta.models.TrainingCentres;

import java.time.LocalDate;

public class TechCentre extends TrainingCenter {
    private final int max=200;
    private final String courseName;
    public TechCentre (String courseName) {
        this.courseName = courseName;
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

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (!(o instanceof TechCentre that)) return false;

        if (max != that.max) return false;
        if (months != that.months) return false;
        if (!courseName.equals(that.courseName)) return false;
        if (!startDate.equals(that.startDate)) return false;
        return endDate.equals(that.endDate);
    }

    @Override
    public int hashCode () {
        int result = max;
        result = 31 * result + courseName.hashCode();
        result = 31 * result + months;
        result = 31 * result + startDate.hashCode();
        result = 31 * result + endDate.hashCode();
        return result;
    }
}