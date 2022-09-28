package com.sparta;

import com.sparta.models.util.Randomizer;


import java.util.List;

public class Trainee {
	private static int idIncrement = 0;
	private final int id;

	public Trainee () {
		this.id = idIncrement++;
	}

	public int getId () {
		return id;
	}

	public void generateTrainees(List<Trainee> traineeList) {
		int numOfTrainees = Randomizer.getRandom(50,100);
		for(int i = 0; i <= numOfTrainees; i++) {
			traineeList.add(new Trainee());
		}
	}
}
