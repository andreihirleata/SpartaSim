package com.sparta.models.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;



class TimeManagerTest {

	@Test
	void getMonthsPassed () {
		for(int i = 1; i < 10; i++) {
			Assertions.assertEquals(LocalDate.now().plusMonths(i), TimeManager.getMonthsPassed(i));
			Assertions.assertTrue(TimeManager.getMonthsPassed(i) instanceof LocalDate);
		}
	}

	@Test
	void testGetMonthsPassed () {
	}

	@Test
	void getCurrentDate () {
		for(int i = 1; i < 10; i++) {
			Assertions.assertEquals(LocalDate.now().plusMonths(i), TimeManager.getCurrentDate().plusMonths(i));
			Assertions.assertTrue(TimeManager.getCurrentDate() instanceof LocalDate);
		}

	}

	@Test
	void getStartDate () {
		for(int i = 1; i < 10; i++) {
			Assertions.assertEquals(LocalDate.now().plusMonths(i), TimeManager.getStartDate(i));
			Assertions.assertTrue(TimeManager.getStartDate(i) instanceof LocalDate);
			Assertions.assertTrue(TimeManager.getStartDate(i).isBefore(TimeManager.getEndDate(i)));
		}
	}

	@Test
	void getEndDate () {
		for(int i = 1; i < 10; i++) {
			Assertions.assertEquals(LocalDate.now().plusMonths(i), TimeManager.getStartDate(i));
			Assertions.assertTrue(TimeManager.getEndDate(i) instanceof LocalDate);
			Assertions.assertTrue(TimeManager.getEndDate(i + 1).isAfter(TimeManager.getStartDate(i)));
		}
	}

	@Test
	void courseRunning () {
		for(int i = 1; i < 20; i++) {
			LocalDate before = TimeManager.getEndDate(i + 1);
			LocalDate after = TimeManager.getMonthsPassed(i);
			Assertions.assertTrue(!TimeManager.courseRunning());
		}
	}

}