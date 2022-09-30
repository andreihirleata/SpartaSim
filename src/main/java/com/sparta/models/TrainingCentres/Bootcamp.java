package com.sparta.models.TrainingCentres;

import com.sparta.Trainee;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.function.Consumer;

public class Bootcamp extends TrainingCenter {
    private final int max=500;
    private int months;
    private LocalDate startDate = LocalDate.now();
    private LocalDate clientPlacementDate = startDate.plusMonths(3);

    public boolean closureCheck(int monthsRunning) {
        if(months < 3 && getTraineeList().size() >= 25) {
            months = 0;
            System.out.println("months post reset: " + months);
        }
        months++;
        System.out.println("Testing months: " + months);
        return months == 3 && getTraineeList().size() < 25;
    }

    public boolean clientPlacementCheck() {
        return startDate.isAfter(clientPlacementDate) || startDate.isEqual(clientPlacementDate);
    }

    @Override
    public boolean isFull() {
        return getTraineeList().size() >= max;
    }


    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (!(o instanceof Bootcamp trainees)) return false;

        if (max != trainees.max) return false;
        if (months != trainees.months) return false;
        if (!startDate.equals(trainees.startDate)) return false;
        return clientPlacementDate.equals(trainees.clientPlacementDate);
    }

    @Override
    public int hashCode () {
        int result = max;
        result = 31 * result + months;
        result = 31 * result + startDate.hashCode();
        return result;
    }

    @Override
    public Iterator<Trainee> iterator () {
        return new Iterator<Trainee>() {
            @Override
            public boolean hasNext () {
                return false;
            }

            @Override
            public Trainee next () {
                return null;
            }
        };
    }
}
