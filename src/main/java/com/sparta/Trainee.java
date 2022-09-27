package com.sparta;

import com.sparta.models.util.Randomizer;

import java.util.ArrayList;
import java.util.List;

public class Trainee {
	private static int idIncrement = 0;
	private final int id;
	private static List<Trainee> waitingList = new ArrayList<>();
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

	public static List<Trainee> getWaitingList() {
		return waitingList;
	}

	public static void generateTrainees() {
		int numOfTrainees = Randomizer.getRandom(50,100);
		for(int i = 0; i <= numOfTrainees; i++) {
			Trainee trainee = new Trainee();
			traineeList.add(trainee);
			getWaitingList().add(trainee);
		}
	}

	public static void openDoors() {
		int numOfTrainees = Randomizer.getRandom(0,50);
		for (int i = 0; i < numOfTrainees; i++) {
			assgintoTraining(getWaitingList().get(0));
		}
	}

	public static void assgintoTraining(Trainee trainee) {
			for(TrainingCenter t:Academy.centerList)
			{
				if(t.isFull()==false) {
					t.getTraineeList().add(trainee);
					getWaitingList().remove(trainee);
					return;
				}
			}
	}
}
