package com.sparta;

public class Trainee {
	private static int idIncrement = 0;
	private final int id;

	public Trainee () {
		this.id = idIncrement++;
	}

	public int getId () {
		return id;
	}
}
