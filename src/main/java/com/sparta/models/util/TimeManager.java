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

	public LocalDate getMonthsPassed (int months) {
		return monthsPassed.plusMonths(months);
	}

	public LocalDate getCurrentDate () {
		return currentDate;
	}

	public LocalDate getStartDate (int dateStarted) {
		return startDate.plusMonths(dateStarted);
	}

	public LocalDate getEndDate (int courseDuration) {
		return endDate.plusMonths(courseDuration);
	}

	public boolean courseRunning() {
		return monthsPassed.isBefore(endDate);
	}
}
