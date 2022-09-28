package com.sparta.models.TrainingCentres;

import com.sparta.Academy;
import com.sparta.Trainee;
import com.sparta.models.util.Randomizer;

import java.util.ArrayList;
import java.util.List;

public abstract class TrainingCenter {
    private static int centerID =0;
    private static List<Trainee> traineeList = new ArrayList<>();
    private static int max;


    public static List<Trainee> getTraineeList() {
        return traineeList;
    }

    public TrainingCenter(){
        setCenterID(centerID++);
    }

    public static boolean isFull() {
        return getTraineeList().size() >= max;
    }

    public int getCenterID() {return centerID;}

    public void setCenterID(int centerID) {
        this.centerID = centerID;
    }

    public static void openDoors() {
        int numOfTrainees = Randomizer.getRandom(0,50);
        for (int i = 0; i < numOfTrainees; i++) {
            assgintoTraining(Trainee.getWaitingList().getFirst());
        }
    }

    public static void assgintoTraining(Trainee trainee) {
        for(TrainingCenter t: Academy.centerList)
        {
            if(!isFull()) {
                getTraineeList().add(trainee);
                Trainee.getWaitingList().remove(trainee);
                return;
            }
        }
    }

    @Override
    public String toString() {
        return "TrainingCenter{" +
                "centerID=" + centerID +
                '}';
    }


}
