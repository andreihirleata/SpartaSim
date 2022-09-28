//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.sparta.models.util;

import java.time.LocalDate;

public class TimeManager {
    private static LocalDate monthsPassed;
    private static LocalDate startingDate;
    private static LocalDate currentDate;
    private static LocalDate endDate;

    public TimeManager() {
        currentDate = LocalDate.now();
        startingDate = currentDate;
        endDate = currentDate;
        monthsPassed = currentDate;
    }

    public static LocalDate getSimulationEndDate(int numOfMonths) {
        return endDate.plusMonths((long)numOfMonths);
    }

    public static LocalDate getStartingDate(int startMonth) {
        return startingDate.plusMonths((long)startMonth);
    }

    public static LocalDate getCurrentDate() {
        return currentDate;
    }

    public static LocalDate getMonthsPassed(int timePassed) {
        return monthsPassed.plusMonths((long)timePassed);
    }

    public static LocalDate getTraineeEndDate() {
        return currentDate.plusMonths(2L);
    }
}
