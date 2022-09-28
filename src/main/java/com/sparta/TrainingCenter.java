package com.sparta;

import com.sparta.models.util.Randomizer;

import java.util.ArrayList;
import java.util.List;

public class TrainingCenter {
    private static int centerID =0;
    private static List<Trainee> traineeList = new ArrayList<>();

    private static final int max = 100;

    public static List<Trainee> getTraineeList() {
        return traineeList;
    }

    public TrainingCenter(){
        setCenterID(centerID++);
    }

    public static boolean isFull() {
        if(getTraineeList().size()<max)
        {
            return false;
        }
        return true;
    }

    public int getCenterID() {return centerID;}

    public void setCenterID(int centerID) {
        this.centerID = centerID;
    }

    public static void openDoors() {
        int numOfTrainees = Randomizer.getRandom(0,50);
        for (int i = 0; i < numOfTrainees; i++) {
            assgintoTraining(Trainee.getWaitingList().get(0));
        }
    }

    public static void assgintoTraining(Trainee trainee) {
        for(TrainingCenter t:Academy.centerList)
        {
            if(t.isFull()==false) {
                t.getTraineeList().add(trainee);
                Trainee.getWaitingList().remove(trainee);
                return;
            }
        }
    }

    public static void closeCenters() {
        for(TrainingCenter tc:Academy.centerList)
        {
            if(tc.getTraineeList().size()<25)
            {
                for(Trainee t:tc.getTraineeList()) {
                    Trainee.getWaitingList().add(t);
                }
                tc.getTraineeList().clear();
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
