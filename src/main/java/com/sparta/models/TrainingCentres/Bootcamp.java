package com.sparta.models.TrainingCentres;

import java.time.LocalDate;

public class Bootcamp extends TrainingCenter {
    private final int max=500;
    private int months = 0;
    private LocalDate startDate = LocalDate.now();
    private LocalDate endDate = LocalDate.now().plusMonths(3);


    public boolean closeCourse() {
        return startDate.isBefore(endDate) || startDate.equals(endDate);
    }

    public boolean closureCheck(int monthsRunning) {
        LocalDate elapsed = startDate.plusMonths(monthsRunning);
        if(elapsed.isBefore(endDate) && getTraineeList().size() > 25) {
            elapsed = LocalDate.now();
        }
        return elapsed.isAfter(startDate) && getTraineeList().size() < 25;
    }

    public Bootcamp(){
        this.maxMonths = 3;
    }

    @Override
    public boolean isFull() {
        return getTraineeList().size() >= max;
    }

    @Override
    public String toString () {
        return "Bootcamp{" +
                "max=" + max +
                ", months=" + months +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (!(o instanceof Bootcamp bootcamp)) return false;

        if (max != bootcamp.max) return false;
        if (months != bootcamp.months) return false;
        if (!startDate.equals(bootcamp.startDate)) return false;
        return endDate.equals(bootcamp.endDate);
    }

    @Override
    public int hashCode () {
        int result = max;
        result = 31 * result + months;
        result = 31 * result + startDate.hashCode();
        result = 31 * result + endDate.hashCode();
        return result;
    }
}
