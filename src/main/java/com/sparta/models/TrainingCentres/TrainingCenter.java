package com.sparta.models.TrainingCentres;

import com.sparta.Academy;
import com.sparta.Trainee;

import com.sparta.models.util.Randomizer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class TrainingCenter {
    private static int centerID =0;
    private static List<Trainee> traineeList = new ArrayList<>();

    public static boolean closed = false;

    public static List<Trainee> getTraineeList() {
        return traineeList;
    }

    public TrainingCenter(){
        setCenterID(centerID++);
    }

    public abstract boolean isFull();

    public int getCenterID() {return centerID;}

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
        } while(t.isFull());

        getTraineeList().add(trainee);
        Trainee.getWaitingList().remove(trainee);
    }

    public static void closeCenters() {
        for(TrainingCenter tc:Academy.centerList)
        {
            if(tc.getTraineeList().size()<25)
            {
                for(Trainee t:tc.getTraineeList()) {
                    Trainee.getWaitingList().addFirst(t);
                }
                tc.closed=true;
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
