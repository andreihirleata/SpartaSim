package com.sparta.models.TrainingCentres;

import com.sparta.Academy;
import com.sparta.Trainee;
import com.sparta.models.util.Randomizer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public abstract class TrainingCenter {
	private static int centerID = 0;
	private List<Trainee> traineeList = new ArrayList<>();


	private boolean closed = false;

	public void setClosed (boolean closed) {
		this.closed = closed;
	}

	public boolean getClosed () {
		return this.closed;
	}

	public List<Trainee> getTraineeList () {
		return traineeList;
	}

	public TrainingCenter () {
		setCenterID(centerID++);
	}

	public abstract boolean isFull ();

	public void setMonthsRunning (int monthsRunning) {
		this.monthsRunning = monthsRunning;
	}

	private int monthsRunning = 0;

	public int getMonthsRunning () {
		return monthsRunning;
	}

	public int getCenterID () {
		return centerID;
	}

	public boolean isClosed () {
		return closed;
	}

	public void setCenterID (int centerID) {
		this.centerID = centerID;
	}

	public static void openDoors() {

		Iterator<TrainingCenter> centers = Academy.centerList.iterator();
		for(TrainingCenter tc : Academy.centerList) {
			int numOfTrainees = Randomizer.getRandom(0,50);
			for (int i = 0; i < numOfTrainees; i++) {
				if(Trainee.getWaitingList().peek() != null) {
					assgintoTraining(Trainee.getWaitingList().peek(), tc);
				}
			}
		}
//		for(TrainingCenter t: Academy.centerList){
//			t.getTraineeList().stream().filter(tr -> tr.isIsTraining()).forEach(tr -> tr.setMonthsTrained(tr.getMonthsTrained() + 1));
//		}
	}

	public void train(List<Trainee> traineeList) {
		traineeList.stream().forEach(tr ->{
			if(tr != null) tr.setMonthsTrained(tr.getMonthsTrained() + 1);
		});
	}

	public static void assgintoTraining(Trainee trainee,TrainingCenter tc) {
//		Iterator<TrainingCenter> centers = Academy.centerList.iterator();
//		TrainingCenter t;
//		do {
//			if (!centers.hasNext()) {
//				return;
//			}
//			t = centers.next();
//		} while(t.isFull() || t.isClosed());
		if(!tc.isFull() && !tc.isClosed()) {
			tc.getTraineeList().add(trainee);
			Trainee.getWaitingList().remove(trainee);
		}
	}

	public static void assignToClient() {

	}
	public static void closeCenters () {
		for (TrainingCenter tc : Academy.centerList) {
			if (tc instanceof Bootcamp && ((Bootcamp) tc).closureCheck(tc.monthsRunning)) {

				tc.getTraineeList().forEach(Trainee.getWaitingList()::addFirst);
				tc.setClosed(true);
				tc.getTraineeList().clear();
			}

			if (tc instanceof TrainingHub && ((TrainingHub) tc).closureCheck(tc.monthsRunning)) {

				tc.getTraineeList().forEach(Trainee.getWaitingList()::addFirst);
				tc.setClosed(true);
				tc.getTraineeList().clear();
			}

			if (tc instanceof TechCentre && ((TechCentre) tc).closureCheck(tc.monthsRunning)) {

				tc.getTraineeList().forEach(Trainee.getWaitingList()::addFirst);
				tc.setClosed(true);
				tc.getTraineeList().clear();
			}



//			for (Trainee t : tc.getTraineeList()) {
//				Trainee.getWaitingList().addFirst(t);
//			}
			tc.setMonthsRunning(tc.getMonthsRunning() + 1);
		}
	}

	public void assingToBench() {
		List<Trainee> trList = this.getTraineeList();
		for(int i = 0; i < trList.size(); i++) {
			Trainee tr = trList.get(i);
			if(tr != null && tr.getMonthsTrained() >= 3) {
				Academy.benchList.add(tr);
				this.getTraineeList().remove(tr);
			}
		}
	}
	@Override
	public String toString () {
		return "TrainingCenter{" +
				"centerID=" + centerID +
				'}';
	}



}