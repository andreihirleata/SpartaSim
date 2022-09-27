package com.sparta;

import com.sparta.models.util.Randomizer;

import java.util.ArrayList;
import java.util.List;

public class Trainee {
	private static int idIncrement = 0;
	private final int id;



	private static List<Trainee> traineeList = new ArrayList<>();

	public Trainee () {
		this.id = idIncrement++;
	}

	public int getId () {
		return id;
	}

	public static List<Trainee> getTraineeList() {
		return traineeList;
	}

	public static void generateTrainees() {
		int numOfTrainees = Randomizer.getRandom(50,100);
		for(int i = 0; i <= numOfTrainees; i++) {
			traineeList.add(new Trainee());
		}
	}
}
