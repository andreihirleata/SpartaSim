package com.sparta.models.util;

import java.time.LocalDate;

public class TimeManager {
	private static LocalDate monthsPassed;
	private static LocalDate currentDate;
	private static LocalDate startDate;
	private static LocalDate endDate;

	public TimeManager() {
		currentDate = LocalDate.now();
		startDate = currentDate;
		endDate = currentDate;
	}

	public static LocalDate getMonthsPassed (int months) {
		return monthsPassed.plusMonths(months);
	}

	public static LocalDate getCurrentDate () {
		return currentDate;
	}

	public static LocalDate getStartDate (int dateStarted) {
		return startDate.plusMonths(dateStarted);
	}

	public static LocalDate getEndDate (int courseDuration) {return endDate.plusMonths(courseDuration);}

	public static boolean courseRunning() {
		return monthsPassed.isBefore(endDate);
	}
}
