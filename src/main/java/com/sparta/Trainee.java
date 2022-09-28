package com.sparta;

import com.sparta.models.factory.TraineeFactory;
import com.sparta.models.util.Randomizer;

import java.util.ArrayList;
import java.util.List;

public class Trainee {
	private final String courseName;
	private static int idIncrement = 0;
	private final int id;
	private static List<Trainee> waitingList = new ArrayList<>();

	public Trainee (String courseName) {
		this.courseName = courseName;
		this.id = idIncrement++;
	}

	public int getId () {
		return id;
	}

	public static List<Trainee> getWaitingList() {
		return waitingList;
	}

	public static void generateTrainees() {
		int numOfTrainees = Randomizer.getRandom(50,100);
		for(int i = 0; i <= numOfTrainees; i++) {
			Trainee trainee = TraineeFactory.generateTrainee();
			System.out.println(trainee.courseName);
			getWaitingList().add(trainee);
		}
	}
}