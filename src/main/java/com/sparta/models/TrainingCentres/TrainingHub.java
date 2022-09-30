package com.sparta.models.TrainingCentres;

import com.sparta.Trainee;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.function.Consumer;

public class TrainingHub extends TrainingCenter {
    private final int max=100;
    private LocalDate startDate = LocalDate.now();
    private int months;

    public boolean closureCheck(int monthsRunning) {
        if(months < 1 && getTraineeList().size() >= 25) {
            months = 0;
        }
        months++;
        return months == 1 && getTraineeList().size() <= 25;
    }

    public TrainingHub() {
        this.maxMonths = 1;
    }

    @Override
    public boolean isFull() {
        return getTraineeList().size() >= max;
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
