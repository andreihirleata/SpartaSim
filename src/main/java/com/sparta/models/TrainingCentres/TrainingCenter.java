package com.sparta.models.TrainingCentres;

import com.sparta.Academy;
import com.sparta.Trainee;

import com.sparta.models.util.Randomizer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class TrainingCenter {
    private static int centerID =0;
    private  List<Trainee> traineeList = new ArrayList<>();


    private  boolean closed = false;

    public void setClosed(boolean closed) {
        this.closed = closed;
    }
public boolean getClosed() {
        return this.closed;
}
    public  List<Trainee> getTraineeList() {
        return traineeList;
    }

    public TrainingCenter(){
        setCenterID(centerID++);
    }

    public abstract boolean isFull();

    public void setMonthsRunning(int monthsRunning) {
        this.monthsRunning = monthsRunning;
    }

    private int monthsRunning = 0;

    public int getMonthsRunning() {
        return monthsRunning;
    }
    public int getCenterID() {return centerID;}
    public boolean isClosed() {return closed;}

    public void setCenterID(int centerID) {
        this.centerID = centerID;
    }

    public static void openDoors() {
        int numOfTrainees = Randomizer.getRandom(0,50);
        for (int i = 0; i < numOfTrainees; i++) {
            assgintoTraining(Trainee.getWaitingList().peek());
        }
    }

    public static void assgintoTraining(Trainee trainee) {
        Iterator var1 = Academy.centerList.iterator();

        TrainingCenter t;
        do {
            if (!var1.hasNext()) {
                return;
            }

            t = (TrainingCenter)var1.next();
        } while(t.isFull() || t.isClosed());

        t.getTraineeList().add(trainee);
        Trainee.getWaitingList().remove(trainee);
    }

    public static void closeCenters() {
        for(TrainingCenter tc:Academy.centerList) {
            if (tc.getMonthsRunning() >= 1) {
                if (tc.getTraineeList().size() < 25) {
                    for (Trainee t : tc.getTraineeList()) {
                        Trainee.getWaitingList().addFirst(t);
                    }
                    tc.setClosed(true);
                    tc.getTraineeList().clear();
                }
            }
            tc.setMonthsRunning(tc.getMonthsRunning() + 1);
        }
    }

    @Override
    public String toString() {
        return "TrainingCenter{" +
                "centerID=" + centerID +
                '}';
    }


}