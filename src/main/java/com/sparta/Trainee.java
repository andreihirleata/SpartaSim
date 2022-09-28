package com.sparta;

import com.sparta.models.factory.TraineeFactory;
import com.sparta.models.util.Randomizer;

import java.util.ArrayDeque;
import java.util.Deque;

public class Trainee {
	private final String courseName;
	private static int idIncrement = 0;
	private final int id;
	private static Deque<Trainee> waitingList = new ArrayDeque<>();

	public Trainee (String courseName) {
		this.courseName = courseName;
		this.id = idIncrement++;
	}

	public int getId () {
		return id;
	}

	public static Deque<Trainee> getWaitingList() {
		return waitingList;
	}

	public static void generateTrainees() {
		int numOfTrainees = Randomizer.getRandom(50,100);
		for(int i = 0; i <= numOfTrainees; i++) {
			Trainee trainee = TraineeFactory.generateTrainee();
			getWaitingList().add(trainee);
		}
	}
}