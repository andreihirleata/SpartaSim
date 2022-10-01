package com.sparta;

import com.sparta.models.TrainingCentres.factory.TraineeFactory;
import com.sparta.models.util.Randomizer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class Trainee implements Iterable<Trainee>{
	private final String courseName;
	private static int idIncrement = 0;
	private final int id;

	private int monthsTrained = 0;

	private static Deque<Trainee> waitingList = new ArrayDeque<>();

	public Trainee (String courseName) {
		this.courseName = courseName;
		this.id = idIncrement++;
	}
	public  int getMonthsTrained() {
		return this.monthsTrained;
	}

	public  void setMonthsTrained(int monthsTrained) {
		this.monthsTrained = monthsTrained;
	}

	public int getId () {
		return id;
	}

	public String getCourse () {
		return courseName;
	}

	public static Deque<Trainee> getWaitingList () {
		return waitingList;
	}

	public static Trainee setWaitingList (Trainee t) {
		waitingList.addFirst(t);
		System.out.println("Testing trainee passed in forEach loop: " + t.toString());
		System.out.println("Testing waiting list: " + waitingList.toString());
		return t;
	}

	public static void generateTrainees () {
		int numOfTrainees = Randomizer.getRandom(50, 100);
		for (int i = 0; i <= numOfTrainees; i++) {
			Trainee trainee = TraineeFactory.generateTrainee();
			getWaitingList().add(trainee);
		}
	}

	@Override
	public String toString() {
		return "Trainee{" +
				"courseName='" + courseName + '\'' +
				", id=" + id +
				", monthsTrained=" + monthsTrained +
				'}';
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