package com.sparta;

import com.sparta.models.util.Randomizer;

import java.util.ArrayList;
import java.util.List;

public class Trainee {
	private static int idIncrement = 0;
	private final int id;
	private static List<Trainee> waitingList = new ArrayList<>();

	public Trainee () {
		this.id = idIncrement++;
	}

	public int getId () {
		return id;
	}


	public static List<Trainee> getWaitingList() {
		return waitingList;
	}

}
