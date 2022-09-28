package com.sparta;

import com.sparta.models.util.Randomizer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Trainee {
	private static int idIncrement = 0;
	private final int id;
	private static ArrayDeque<Trainee> waitingList = new ArrayDeque<>();

	public Trainee () {
		this.id = idIncrement++;
	}

	public int getId () {
		return id;
	}

	public static ArrayDeque<Trainee> getWaitingList() {
		return waitingList;
	}

	public static void generateTrainees() {
		int numOfTrainees = Randomizer.getRandom(50,100);
		for(int i = 0; i <= numOfTrainees; i++) {
			Trainee trainee = new Trainee();
			getWaitingList().add(trainee);
		}
	}
}