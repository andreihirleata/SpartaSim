package com.sparta.models.TrainingCentres;

import com.sparta.Trainee;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.function.Consumer;

public class TechCentre extends TrainingCenter {
    private final int max=200;

    private final String COURSE_NAME;

    public TechCentre (String courseName) {
        this.COURSE_NAME = courseName;

    }

    private int months = 0;
    private LocalDate startDate;
    private LocalDate closureDate;
    private LocalDate endDate;


    public boolean closureCheck(int monthsRunning) {
        if(months < 1 && getTraineeList().size() >= 25) {
            months = 0;
        }
        months++;
        return months == 1 && getTraineeList().size() <= 25;
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
        if (!COURSE_NAME.equals(that.COURSE_NAME)) return false;
        if (!startDate.equals(that.startDate)) return false;
        return closureDate.equals(that.closureDate);
    }

    @Override
    public int hashCode () {
        int result = max;
        result = 31 * result + COURSE_NAME.hashCode();
        result = 31 * result + months;
        result = 31 * result + startDate.hashCode();
        result = 31 * result + closureDate.hashCode();
        return result;
    }

//    @Override
//    public Iterator<Trainee> iterator () {
//        return new Iterator<Trainee>() {
//            @Override
//            public boolean hasNext () {
//                return false;
//            }
//
//            @Override
//            public Trainee next () {
//                return null;
//            }
//        };
//    }
}