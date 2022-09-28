package com.sparta;

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

    @Override
    public String toString() {
        return "TrainingCenter{" +
                "centerID=" + centerID +
                '}';
    }


}
