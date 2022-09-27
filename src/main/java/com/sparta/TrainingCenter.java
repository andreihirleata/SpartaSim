package com.sparta;

import java.util.ArrayList;
import java.util.List;

public class TrainingCenter {
    private static int centerID =0;
    private  List<Trainee> traineeList = new ArrayList<>();

    public List<Trainee> getTraineeList() {
        return traineeList;
    }

    public TrainingCenter(){
        setCenterID(centerID++);
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
